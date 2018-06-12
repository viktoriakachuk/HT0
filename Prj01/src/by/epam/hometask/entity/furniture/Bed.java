package by.epam.hometask.entity.furniture;

import by.epam.hometask.entity.AbstractFurniture;

public class Bed extends AbstractFurniture {
    public Bed(String furnitureName, int occupiedSpace) {
        super(furnitureName, occupiedSpace);
    }

    @Override
    public String toString() {
        return "Bed{} " + super.toString();
    }
}
