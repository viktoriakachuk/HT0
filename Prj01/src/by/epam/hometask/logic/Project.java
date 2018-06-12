package by.epam.hometask.logic;

import by.epam.hometask.entity.AbstractFurniture;
import by.epam.hometask.entity.Bulb;
import by.epam.hometask.entity.Room;
import by.epam.hometask.exception.*;

import java.util.List;

public class Project {
    private static final int MAX_ILLUMINANCE = 4000;        //we
    private static final int ILLUMINANCE_COEFFICIENT = 700; //fight
    private static final double SPACE_COEFFICIENT = 0.7;    //magic numbers

    /**
     * checks windows in the room
     */
    public boolean checkWindowIlluminance(Room room) throws IlluminanceTooMuchException, NoWindowsException {
        int windowIlluminance = 0;
        if (room.getWindow() < 1){
            throw new NoWindowsException("at least 1 window is required!");
        }
        else {
            windowIlluminance = room.getWindow() * ILLUMINANCE_COEFFICIENT;
            if (windowIlluminance > MAX_ILLUMINANCE) {
                throw new IlluminanceTooMuchException("too much windows in the room!");
            } else {
                return true;
            }
        }
    }

    /**
     * checks room for aggregate illuminance
     * generates exception if it is too much
     */
    public boolean checkAggregateIlluminance(Room room, Bulb bulb) throws IlluminanceTooMuchException, NegativeIlluminanceException {
        if (bulb.getIlluminance() <= 0 ){
            throw new NegativeIlluminanceException("bulb illuminance should be more than 0!");
        }
        else {
            int aggregateIlluminance = 0;
            int windowIlluminance = room.getWindow() * ILLUMINANCE_COEFFICIENT;
            aggregateIlluminance += windowIlluminance;
            List<Bulb> bulbs = room.getBulbs();
            for (Bulb b : bulbs) {
                aggregateIlluminance += b.getIlluminance();
            }
            aggregateIlluminance += bulb.getIlluminance();
            if (aggregateIlluminance > MAX_ILLUMINANCE) {
                throw new IlluminanceTooMuchException("too much illuminance in the room!");
            } else {
                return true;
            }
        }
    }


    /**
     * checks room for positive space
     */
    public boolean checkInitialSpace (Room room) throws NegativeSpaceException{
        if (room.getSpace() <= 0){
            throw new NegativeSpaceException("room space should be more than 0!");
        }
        else{
            return true;
        }
    }

    /**
     * checks room for aggregate occupied space
     * generates exception if it is too much
     */
    public boolean checkFurnitureSpace (Room room, AbstractFurniture fur) throws SpaceUsageTooMuchException, NegativeSpaceException {
        if (fur.getOccupiedSpace() <= 0){
            throw new NegativeSpaceException("furniture space should be more than 0!");
        }
        else{
            int aggregateSpace = 0;
            List<AbstractFurniture> furniture = room.getFurniture();
            for (AbstractFurniture f : furniture){
                aggregateSpace += f.getOccupiedSpace();
            }
            double aggrSpace = (double)(aggregateSpace + fur.getOccupiedSpace());
            if (aggrSpace > SPACE_COEFFICIENT * (double)(room.getSpace())){
                throw new SpaceUsageTooMuchException("that piece of furniture takes too much space!");
            }

            return true;
        }
    }

    /**
     * calculates spare space in the room
     */
    public int[] calcSpareSpace(Room room){
        int spareSpace = 0;
        int furnitureSpace = 0;
        List<AbstractFurniture> furniture = room.getFurniture();
        for (AbstractFurniture fur : furniture){
            furnitureSpace += fur.getOccupiedSpace();
        }
        spareSpace = room.getSpace() - furnitureSpace;
        double doublePercentage = (double)spareSpace/(double)room.getSpace();
        int spareSpacePercentage = (int) (doublePercentage*100);
        return new int[] {furnitureSpace, spareSpace, spareSpacePercentage};
    }

    /**
     * calculates room illuminance
     */
    public int calcIlluminance(Room room){
        int aggregateIlluminance = 0;
        int windowIlluminance = room.getWindow() * ILLUMINANCE_COEFFICIENT;
        aggregateIlluminance += windowIlluminance;
        List<Bulb> bulbs = room.getBulbs();
        for (Bulb b : bulbs) {
            aggregateIlluminance += b.getIlluminance();
        }
        return aggregateIlluminance;
    }
}
