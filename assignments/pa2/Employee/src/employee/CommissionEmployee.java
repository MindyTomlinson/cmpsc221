package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class CommissionEmployee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    public CommissionEmployee(
            String firstName, 
            String lastName, 
            String socialSecurityNumber, 
            double grossSales, 
            double commissionRate) {
        
        // validate grossSales
        if (grossSales < 0.0) 
            throw new IllegalArgumentException(
                    "Gross sales must be greater than zero");
        
        // validate commissionRate
        if (commissionRate <= 0.0 || commissionRate >= 1.0) 
            throw new IllegalArgumentException(
                    "Commission rate must be between 0 and 1");
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) 
            throw new IllegalArgumentException(
                    "Gross sales must be greater than zero");
        
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) 
            throw new IllegalArgumentException(
                    "Commission rate must be between 0 and 1");
        this.commissionRate = commissionRate;
    }
   
    public double earnings() {
        return grossSales * commissionRate;
    }
    
    @Override
    public String toString() {
        return String.format(
                "%s: %s %s with ssn: %s%n"
                + "  %s: %.2f%n"
                + "  %s: %.2f%n"
                + "  %s: $%.2f", 
                "Commissioned Employee", 
                    getFirstName(), getLastName(), getSocialSecurityNumber(),
                "Gross Sales", getGrossSales(), 
                "Commission Rate", getCommissionRate(),
                "Earnings", earnings());
    }
}
