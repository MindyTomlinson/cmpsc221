package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class Salary implements Renumeration {
    
    private double salary;

    public Salary(double salary) { 
        if (salary < 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
        this.salary = salary;
    }
    
    public Salary(Salary salary) { // constructor using another Salary object
        this(salary.getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
        this.salary = salary;
    }
    
    @Override
    public double pay() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Salary: $%.2f%n",
                salary);
    }

    void setWeeklySalary(Salary salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
