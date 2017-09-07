package employee;

import renumeration.Commission;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class CommissionedEmployee extends Employee {
    
    private Commission commission;

    public CommissionedEmployee(String firstName, String lastName, String ssn,
            double grossSales, double commissionRate) {
        
        super(firstName, lastName, ssn);
        
        // Create new Commission object with arguments 
        // grossSales and commissionRate
        this.commission = new Commission(grossSales, commissionRate);
    }

    public CommissionedEmployee(String firstName, String lastName, String ssn,
            Commission commission) {
        
        super(firstName, lastName, ssn);
        
        this.commission = commission;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }
    
    public void setCommissionRate(double commissionRate) {
        double grossSales = commission.getGrossSales();
        this.commission = new Commission(grossSales, commissionRate);
    }
    
    public void setGrossSales(double grossSales) {
        double commissionRate = commission.getCommissionRate();
        this.commission = new Commission(grossSales, commissionRate);
    }
    
    @Override
    public double earnings() {
        return commission.pay();
    }
    
    @Override
    public String toString() {
        return String.format("Commissioned Employee: %s"
                + "%s"
                + "Earnings: $%.2f%n",
                super.toString(),
                commission,
                earnings());
    }
}
