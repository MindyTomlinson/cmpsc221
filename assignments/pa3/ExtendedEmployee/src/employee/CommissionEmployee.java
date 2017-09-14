package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class CommissionEmployee extends Employee {
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    public CommissionEmployee(
            String firstName, 
            String lastName,
            String socialSecurityNumber,
            double grossSales, 
            double commissionRate) {
        
        super(firstName, lastName, socialSecurityNumber);
        
        // validate grossSales
        if (grossSales < 0.0) 
            throw new IllegalArgumentException(
                    "Gross sales must be greater than zero");
        
        // validate commissionRate
        if (commissionRate <= 0.0 || commissionRate >= 1.0) 
            throw new IllegalArgumentException(
                    "Commission rate must be between 0 and 1");
        
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
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
   
    @Override
    public double earnings() {
        return grossSales * commissionRate;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Commissioned Employee: %s%n"
                + "  Gross Sales: %.2f%n"
                + "  Commission Rate: %.4f%n"
                + "  Earnings: $%.2f%n",  
                displayName(),
                getGrossSales(), 
                getCommissionRate(),
                earnings());
    }

    @Override
    public void raise(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percent raise must be > 0");
        }
        setCommissionRate(getCommissionRate() * (1 + percent));
    }
}
