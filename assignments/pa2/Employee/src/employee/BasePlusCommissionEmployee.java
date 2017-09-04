package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    
    private double baseSalary;

    public BasePlusCommissionEmployee(
            String firstName, 
            String lastName, 
            String socialSecurityNumber, 
            double grossSales, 
            double commissionRate,
            double baseSalary) {
        
        super(firstName, lastName, socialSecurityNumber, 
                grossSales, commissionRate);
        
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        
        this.baseSalary = baseSalary;
    }
    
    @Override
    public double earnings() {
        
        return baseSalary + super.earnings();
    }

    @Override
    public String toString() {
        return String.format(
                "Base Salary Plus Commissioned Employee: %s %s with ssn: %s%n"
                + "  Gross Sales: %.2f%n"
                + "  Commission Rate: %.2f%n"
                + "  with Base Salary of: $%.2f%n"
                + "  Earnings: $%.2f%n",  
                getFirstName(), getLastName(), getSocialSecurityNumber(),
                getGrossSales(), 
                getCommissionRate(),
                getBaseSalary(),
                earnings());
    }
}
