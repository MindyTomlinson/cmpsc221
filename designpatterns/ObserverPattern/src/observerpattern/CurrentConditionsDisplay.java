package observerpattern;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class CurrentConditionsDisplay implements Observer, Display {

    private double temperature;
    private double humidity;
    private double pressure;
    private final Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        // DANGER: It is not best practice to pass 'this' out of a constructor
        // See http://www.javapractices.com/topic/TopicAction.do?Id=252
        // See https://www.ibm.com/developerworks/library/j-jtp07265/index.html
        // Should use factory instead
    }
   
    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.printf("Displaying Current Conditions:%n"
                + "Temperature: %.2f%n"
                + "Humidity:    %.2f%n"
                + "Pressure:    %.2f%n%n",
                temperature, humidity, pressure);
    } 
}
