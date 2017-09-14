package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class SalariedEmployee extends Employee {

    private double salary;

    public SalariedEmployee(
            String firstName, 
            String lastName, 
            String socialSecurityNumber,
            double salary) {
        
        super(firstName, lastName, socialSecurityNumber);
        
        if (salary <= 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
                
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        
        if (salary <= 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
        
        this.salary = salary;
    }

    @Override
    public double earnings() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "Salaried Employee: %s%n"
                + "  Salary: %.2f%n"
                + "  Earnings: $%.2f%n",  
                displayName(),
                getSalary(), 
                earnings());
    }
    
    @Override
    public void raise(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percent raise must be > 0");
        }
        setSalary(getSalary() * (1 + percent));
    }
}
