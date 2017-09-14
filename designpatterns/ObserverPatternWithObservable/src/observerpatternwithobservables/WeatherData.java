package observerpatternwithobservables;

import java.util.Observable;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class WeatherData extends Observable {
    private double temp;
    private double humidity;
    private double pressure;

    public WeatherData() {
    }
    
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }
    
    public void setMeasurements(double temp, double humidity, double pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }
}
