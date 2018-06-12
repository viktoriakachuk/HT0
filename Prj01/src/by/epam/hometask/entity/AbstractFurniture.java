package by.epam.hometask.entity;

public abstract class AbstractFurniture {
    private String furnitureName;
    private int occupiedSpace;

    public AbstractFurniture(String furnitureName, int occupiedSpace) {
        this.furnitureName = furnitureName;
        this.occupiedSpace = occupiedSpace;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public int getOccupiedSpace() {
        return occupiedSpace;
    }

    public void setOccupiedSpace(int occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
    }

    @Override
    public String toString() {
        return "AbstractFurniture{" +
                "furnitureName='" + furnitureName + '\'' +
                ", occupiedSpace=" + occupiedSpace +
                '}';
    }
}
