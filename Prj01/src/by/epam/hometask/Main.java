package by.epam.hometask;

import by.epam.hometask.entity.Building;
import by.epam.hometask.entity.Bulb;
import by.epam.hometask.entity.Room;
import by.epam.hometask.entity.furniture.Bed;
import by.epam.hometask.entity.furniture.Chair;
import by.epam.hometask.entity.furniture.Table;
import by.epam.hometask.exception.*;



public class Main {
    public static void main(String[] args) {
        Building building1 = new Building("building no.1");
        try {
            building1.addRoom(new Room("room no.1", 20, 2));
            building1.addRoom(new Room("room no.2", 12, 1));
            Room room1 = building1.getRoom("room no.1");
            room1.addBulb(room1, new Bulb(60));
            room1.addBulb(room1, new Bulb(40));
            room1.addFurniture(room1, new Table("dining table", 6));
            Room room2 = building1.getRoom("room no.2");
            room2.addFurniture(room2, new Chair("brown chair", 2));
            room2.addFurniture(room2, new Bed("soft bed", 5));
            building1.describe();
        } catch (IlluminanceTooMuchException e) {
            e.printStackTrace();
        } catch (NoSuchRoomException e) {
            e.printStackTrace();
        } catch (SpaceUsageTooMuchException e) {
            e.printStackTrace();
        } catch (NegativeIlluminanceException e) {
            e.printStackTrace();
        } catch (NegativeSpaceException e) {
            e.printStackTrace();
        } catch (NoWindowsException e) {
            e.printStackTrace();
        }
    }
}


