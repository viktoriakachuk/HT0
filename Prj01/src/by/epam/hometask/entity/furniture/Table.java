package by.epam.hometask.entity.furniture;

import by.epam.hometask.entity.AbstractFurniture;

public class Table extends AbstractFurniture {

    public Table(String furnitureName, int occupiedSpace) {
        super(furnitureName, occupiedSpace);
    }

    @Override
    public String toString() {
        return "Table{} " + super.toString();
    }
}
