package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class HourlyEmployee extends Employee {

    private double hourlyWage;
    private double hoursWorked;

    public HourlyEmployee(
            String firstName, 
            String lastName, 
            String socialSecurityNumber,
            double hourlyWage, 
            double hoursWorked) {
        
        super(firstName, lastName, socialSecurityNumber);
        
        // validate hourlyWage
        if (hourlyWage <= 0.0) 
            throw new IllegalArgumentException("Hourly wage must be > 0.0");
        
        // validate hoursWorked
        if (hoursWorked < 0.0 || hoursWorked > 168.0) 
            throw new IllegalArgumentException(
                    "Hours worked must be between 0.0 and 168.0");
        
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        if (hourlyWage <= 0.0) 
            throw new IllegalArgumentException("Hourly wage must be > 0.0");
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0.0 || hoursWorked > 168.0) 
            throw new IllegalArgumentException(
                    "Hours worked must be between 0.0 and 168.0");
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double earnings() {
        return (hoursWorked > 40.0 ? 
                (hoursWorked - 40) * hourlyWage * 1.5 + 40 * hourlyWage : 
                hoursWorked * hourlyWage);
    }
    
    @Override
    public String toString() {
        return String.format(
                "Hourly Employee: %s%n"
                + "  Hourly Wage: %.2f%n"
                + "  Hours Worked: %.2f%n"
                + "  Earnings: $%.2f%n",  
                displayName(),
                getHourlyWage(), 
                getHoursWorked(),
                earnings());
    }
}
