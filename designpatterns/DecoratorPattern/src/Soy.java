public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", with soy";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
