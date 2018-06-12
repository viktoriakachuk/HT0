package by.epam.hometask.entity.furniture;

import by.epam.hometask.entity.AbstractFurniture;

public class Chair extends AbstractFurniture {
    public Chair(String furnitureName, int occupiedSpace) {
        super(furnitureName, occupiedSpace);
    }

    @Override
    public String toString() {
        return "Chair{} " + super.toString();
    }
}
