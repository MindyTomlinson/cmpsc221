package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class Salary implements Renumeration {
    
    private double weeklySalary;

    public Salary(double salary) {
        if (salary < 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
        this.weeklySalary = salary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
        this.weeklySalary = weeklySalary;
    }
    
    @Override
    public double pay() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return String.format("Salary: $%.2f%n",
                weeklySalary);
    }

    void setWeeklySalary(Salary salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
