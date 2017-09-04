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
                "888-88-8888", 2000.0, 0.05);
        System.out.println(amber);
        
        BasePlusCommissionEmployee shana = new BasePlusCommissionEmployee(
                "Shana","Nissenbaum","777-77-7777", 3000, 0.05, 300);
        System.out.println(shana);
        
        SalariedEmployee julie = new SalariedEmployee("Julie", "Trubitt", 
                "666-66-6666", 1150);
        System.out.println(julie);
        
        HourlyEmployee maggie = new HourlyEmployee("Maggie","Thomas",
                "555-55-5555", 15, 50);
        System.out.println(maggie);
        
        HourlyEmployee marissa = new HourlyEmployee("Marissa", "Rodriguez",
                "444-44-4444", 20, 40);
        System.out.println(marissa);
    }
    
}
