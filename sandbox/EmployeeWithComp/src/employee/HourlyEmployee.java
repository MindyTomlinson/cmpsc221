package employee;

import renumeration.HourlyWage;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class HourlyEmployee extends Employee {

    private HourlyWage hourlyWage;

    public HourlyEmployee(String firstName, String lastName, String ssn, 
            HourlyWage hourlyWage) {
        super(firstName, lastName, ssn);
        this.hourlyWage = hourlyWage;
    }

    

    public HourlyWage getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(HourlyWage hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
    
    @Override
    public double earnings() {
        return hourlyWage.pay();
    }
    
    @Override
    public String toString() {
        return String.format("Hourly Employee: %s"
                + "%s"
                + "Earnings: $%.2f%n",
                super.toString(),
                hourlyWage,
                earnings());
    }
}
