public class StarbuzzCoffee {

    public static void main(String[] args) {

        // Create an espresso
        Beverage beverage = new Espresso();
        printBeverage(beverage);

        // Create a double mocha espresso with whip
        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        printBeverage(beverage1);

        // Create a mocha house blend with soy and whip
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Soy(beverage2);
        beverage2 = new Whip(beverage2);
        printBeverage(beverage2);
    }

    public static void printBeverage(Beverage beverage) {
        System.out.printf("%s: $%.2f%n",
                beverage.getDescription(),
                beverage.cost());
    }
}
