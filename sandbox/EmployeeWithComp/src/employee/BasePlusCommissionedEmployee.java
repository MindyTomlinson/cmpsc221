package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class BasePlusCommissionedEmployee extends Employee {

    private Salary salary;
    private Commission commission;

    public BasePlusCommissionedEmployee(String firstName, String lastName, String ssn,
                                        Salary salary, Commission commission) {
        super(firstName, lastName, ssn);
        this.salary = salary;
        this.commission = commission;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }
    
    @Override
    public double earnings() {
        return commission.pay() + salary.pay();
    }
    
    public String toString() {
        return String.format("Base Salary Plus Commissioned Employee: %s"
                + "%s"
                + "%s"
                + "Earnings: $%.2f%n",
                super.toString(),
                commission,
                salary,
                earnings());
    }
}
