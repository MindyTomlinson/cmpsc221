package employee;

import renumeration.Salary;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class SalariedEmployee extends Employee {

    private Salary salary;

    public SalariedEmployee(String firstName, String lastName, String ssn,
            Salary salary) {
        super(firstName, lastName, ssn);
        this.salary = new Salary(salary);
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
    
    @Override
    public double earnings() {
        return salary.pay();
    }
    
    @Override
    public String toString() {
        return String.format("Salaried Employee: %s"
                + "%s"
                + "Earnings: $%.2f%n",
                super.toString(),
                salary,
                earnings());
    }
}
