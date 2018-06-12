package by.epam.hometask.entity;

import by.epam.hometask.exception.*;
import by.epam.hometask.logic.Project;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingName;
    private List<Room> rooms = new ArrayList<>();

    Project buildProject = new Project();

    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * adds new room to the building if it meets the requirements
     */
    public void addRoom(Room room) throws IlluminanceTooMuchException, NegativeSpaceException, NoWindowsException {
            if (buildProject.checkWindowIlluminance(room) && buildProject.checkInitialSpace(room)){
                rooms.add(room);
                setRooms(rooms);
            }
    }

    /**
     * returns room if it exists
     */
    public Room getRoom(String roomName) throws NoSuchRoomException {
        Room roomToReturn = null;
        for (Room room : rooms){
            if (room.getRoomName().equals(roomName)){
                 roomToReturn = room;
            }
        }
        if (roomToReturn!=null) {
            return roomToReturn;
        }
        else {
            throw new NoSuchRoomException("cannot find such a room!");
        }
    }

    /**
     * describes the whole building with all the rooms, their illuminance and furniture
     */
    public void describe(){
        System.out.println(buildingName);
        for (Room room : rooms){
            System.out.println("  " + room.getRoomName());
            System.out.print("    Illuminance = " + buildProject.calcIlluminance(room) + " lux " +
            "(" + room.getWindow() + " window(s) 700 lux each + bulb(s): ");
            List<Bulb> bulbs = room.getBulbs();
            for (Bulb b : bulbs) {
                System.out.print(b.getIlluminance() + " lux ");
            }
            System.out.println(")");
            System.out.println("    Space = " + room.getSpace() + " sq m "+
                    "(occupied " + buildProject.calcSpareSpace(room)[0] + " sq m, free " +
                    buildProject.calcSpareSpace(room)[1] + " sq m or " + buildProject.calcSpareSpace(room)[2] + "%)");
            if(room.getFurniture().isEmpty()){
                System.out.println("    No furniture in the room!");
            }
            else{
                System.out.println("    Furniture:");
                List<AbstractFurniture> furniture = room.getFurniture();
                for (AbstractFurniture fur : furniture) {
                    System.out.println("      " + fur.getFurnitureName() + " (occupied space " + fur.getOccupiedSpace()+
                    " sq m)");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
