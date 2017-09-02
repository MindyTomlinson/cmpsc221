package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class CommissionEmployee {
    protected final String firstName;
    protected final String lastName;
    protected final String socialSecurityNumber;
    protected double grossSales; // gross weekly sales
    protected double commissionRate; // commission percentage

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
                "%s: %s %s%n"
                + "%s: %s%n"
                + "%s: %.2f%n"
                + "%s: %.2f%n"
                + "%s: %.2f", 
                "commission employee", firstName, lastName, 
                "social security number", socialSecurityNumber,
                "gross sales", grossSales, 
                "commission rate", commissionRate,
                "earnings", earnings());
    }
    
    public static void main(String[] args) {
        CommissionEmployee mindy = new CommissionEmployee("Mindy","Tomlinson",
                "999-99-9999", 100000.0, 0.2);
        System.out.println(mindy);
        
        BasePlusCommissionEmployee amber = new BasePlusCommissionEmployee(
                "Amber","Miller","888-88-8888",50000,0.3,80000);
        System.out.println(amber);
    }
    
}
