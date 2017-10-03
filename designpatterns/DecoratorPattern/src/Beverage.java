public abstract class Beverage {
    String description;
    BeverageSize size;

    public String getDescription() {
        return description;
    }

    public BeverageSize getSize() {
        return size;
    }

    public void setSize(BeverageSize size) {
        this.size = size;
    }

    public abstract double cost();
}
