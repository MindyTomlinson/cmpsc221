package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class EmployeeTest {
    public static void main(String[] args) {
        CommissionEmployee mindy = new CommissionEmployee("Mindy","Tomlinson",
                "999-99-9999", 100000.0, 0.2);
        System.out.println(mindy);
        
        System.out.println();
        
        BasePlusCommissionEmployee amber = new BasePlusCommissionEmployee(
                "Amber","Miller","888-88-8888",50000,0.3,80000);
        System.out.println(amber);
    }
}
