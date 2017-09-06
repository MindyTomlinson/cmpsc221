package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class HourlyWage implements Renumeration {
    
    private double hoursWorked;
    private double hourlyWage;

    public HourlyWage(double hourlyWage, double hoursWorked) {
        if (hourlyWage < 0)
            throw new IllegalArgumentException("Hourly Wage must be >= 0.0");
        if (hoursWorked < 0)
            throw new IllegalArgumentException("Hours Worked must be >= 0.0");
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        if (hourlyWage < 0)
            throw new IllegalArgumentException("Hourly Wage must be >= 0.0");
        this.hourlyWage = hourlyWage;
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0)
            throw new IllegalArgumentException("Hours Worked must be >= 0.0");
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double pay() {
        return ((hoursWorked > 40) ? 
                (40 * hourlyWage + (hoursWorked - 40) * hourlyWage * 1.5) :
                (hoursWorked * hourlyWage));
    }
    
    @Override
    public String toString() {
        return String.format("Hourly Wage: $%.2f%n"
                + "Hours Worked: %.2f%n",
                hourlyWage, hoursWorked);
    }
}
