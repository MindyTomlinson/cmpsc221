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
        
        return baseSalary + (grossSales * commissionRate);
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s %s%n"
                + "%s: %s%n"
                + "%s: %.2f%n"
                + "%s: %.2f%n"
                + "%s: %.2f%n"
                + "%s: %.2f", 
                "commission employee", firstName, lastName, 
                "social security number", socialSecurityNumber,
                "gross sales", grossSales, 
                "commission rate", commissionRate,
                "base salary", baseSalary,
                "earnings", earnings());
    }
   
    public static void main(String[] args) {
        BasePlusCommissionEmployee amber = new BasePlusCommissionEmployee(
                "Amber","Miller","888-88-8888",50000,0.3,80000);
        System.out.println(amber);
    }
}
