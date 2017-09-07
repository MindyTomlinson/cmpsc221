package renumeration;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class Commission implements Renumeration {
    
    private double grossSales;
    private double commissionRate;

    public Commission(double grossSales, double commissionRate) {
        if (grossSales < 0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        if (commissionRate < 0.0 || commissionRate > 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be between 0.0 and 1.0");
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    
    public Commission(Commission commission) {
        this(commission.getGrossSales(), commission.getCommissionRate());
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0.0 || commissionRate > 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be between 0.0 and 1.0");
        this.commissionRate = commissionRate;
    }

    @Override
    public double pay() {
        return grossSales * commissionRate;
    }
    
    @Override
    public String toString() {
        return String.format("Gross Sales: $%.2f%n"
                + "Commission Rate: %.2f%n",
                grossSales, commissionRate);
    }
}
