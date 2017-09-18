public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", with steamed milk";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
