package observerpatternwithobservables;

import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class CurrentConditionsDisplay implements Observer, Display {

    private double temp;
    private double humidity;
    private double pressure;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
        // DANGER: It is not best practice to pass 'this' out of a constructor
        // See http://www.javapractices.com/topic/TopicAction.do?Id=252
        // See https://www.ibm.com/developerworks/library/j-jtp07265/index.html
        // Should use factory instead
    }
   
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("Displaying Current Conditions:%n"
                + "Temperature: %.2f%n"
                + "Humidity:    %.2f%n"
                + "Pressure:    %.2f%n%n",
                    temp, humidity, pressure);
    } 
}
