package employee;

import renumeration.Salary;
import renumeration.HourlyWage;
import renumeration.Commission;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Salary salary1 = new Salary(1150);
        System.out.println(salary1);
        
        HourlyWage hw1 = new HourlyWage(15, 50);
        System.out.println(hw1);
        
        HourlyWage hw2 = new HourlyWage(20, 40);
        System.out.println(hw2);
        
        Commission comm1 = new Commission(2000, 0.05);
        System.out.println(comm1);
        
        SalariedEmployee sha = new SalariedEmployee("Sha", "Yang",
                                        "333-33-3333", salary1);
        System.out.println(sha);
        
        HourlyEmployee ian = new HourlyEmployee("Ian", "Tanning", 
                                        "444-44-4444", hw1);
        System.out.println(ian);
        
        CommissionedEmployee fred1 = new CommissionedEmployee("Fred", "Jones",
                                        "111-11-1111", 
                                        new Commission(2000, 0.05));
        
        CommissionedEmployee fred2 = new CommissionedEmployee("Fred", "Jones",
                                        "111-11-1111", comm1);
        System.out.println("Constructor with gross sales & commission rate:");
        System.out.println(fred1);
        System.out.println("Constructor with Commission object:");
        System.out.println(fred2);
        
        fred2.setCommissionRate(0.1);
        System.out.println("Update commission rate to 0.1:");
        System.out.println(fred2);
        
//        fred2.setCommissionRate(3);
//        System.out.println("Try to set bad commission rate (0.3):");
//        System.out.println(fred2);

        BasePlusCommissionedEmployee sue = new BasePlusCommissionedEmployee(
            "Sue", "Smith", "222-22-2222", salary1, comm1);
        System.out.println(sue);
        
        // If salary1 is updated, is Sue's BasePlusCommissionedEmployee changed?
        salary1.setSalary(80000);
        System.out.println(sue); 
        // YES if salary is initialized in BasePlusCommissionedEmployee's 
        // constructor via this.salary = salary
        // NO if salary is initialized in BasePlusCommissionedEmployee's
        // constructor via this.salary = new Salary(salary)
        // (assuming there's a constructor with that signature for Salary)
    }
}
