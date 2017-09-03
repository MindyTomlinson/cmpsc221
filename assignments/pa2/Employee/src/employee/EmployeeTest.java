package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class EmployeeTest {
    public static void main(String[] args) {
        
        Employee mindy = new Employee("Mindy", "Tomlinson", "999-99-9999");
        
        System.out.println(mindy);
        
        CommissionEmployee amber = new CommissionEmployee("Amber","Miller",
                "888-88-8888", 100000.0, 0.2);
        System.out.println(amber);
        
        BasePlusCommissionEmployee shana = new BasePlusCommissionEmployee(
                "Shana","Nissenbaum","777-77-7777",50000,0.3,80000);
        System.out.println(shana);
    }
}
