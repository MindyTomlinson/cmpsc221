package observerpattern;

import java.util.ArrayList;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class WeatherData implements Subject {
    private double temperature;
    private double humidity;
    private double pressure;
    private ArrayList observers;

    // Constructor
    public WeatherData() {
        observers = new ArrayList();
    }
    
    // Implement Subject interface
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        /*int i = observers.indexOf(o); // Book technique
        if (i >= 0)
        observers.remove(i);*/
        observers.remove(o); // Remove directly
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }
    
    // WeatherData-specific methods
    public void measurementsChanged() {
        notifyObservers();
    }
    
    // Getters and setters
    
    public void setMeasurements(double temperature, double humidity, 
            double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }
}
