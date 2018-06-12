package by.epam.hometask.entity;

import by.epam.hometask.exception.IlluminanceTooMuchException;
import by.epam.hometask.exception.NegativeIlluminanceException;
import by.epam.hometask.exception.NegativeSpaceException;
import by.epam.hometask.exception.SpaceUsageTooMuchException;
import by.epam.hometask.logic.Project;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomName;
    private int space;
    private int window;
    private List<Bulb> bulbs = new ArrayList<>();
    private List<AbstractFurniture> furniture = new ArrayList<>();

    Project buildProject = new Project();

    public Room(String roomName, int space, int window) {
        this.roomName = roomName;
        this.space = space;
        this.window = window;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public List<Bulb> getBulbs() {
        return bulbs;
    }

    public void setBulbs(List<Bulb> bulbs) {
        this.bulbs = bulbs;
    }

    public List<AbstractFurniture> getFurniture() {
        return furniture;
    }

    public void setFurniture(List<AbstractFurniture> furniture) {
        this.furniture = furniture;
    }

    /**
     * adds new bulb to the room if it meets the requirements
     */
    public void addBulb(Room room, Bulb bulb) throws IlluminanceTooMuchException, NegativeIlluminanceException {
        if (buildProject.checkAggregateIlluminance(room, bulb)) {
            bulbs.add(bulb);
            setBulbs(bulbs);
        }
    }

    /**
     * adds new furniture to the room if it meets the requirements
     */
    public void addFurniture(Room room, AbstractFurniture fur) throws SpaceUsageTooMuchException, NegativeSpaceException {
        if (buildProject.checkFurnitureSpace(room, fur)) {
            furniture.add(fur);
            setFurniture(furniture);
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", space=" + space +
                ", window=" + window +
                ", bulbs=" + bulbs +
                ", furniture=" + furniture +
                '}';
    }
}
