
package savingsaccount;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class SavingsAccount {
    
    private static double annualInterestRate;
    
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance >= 0.0) {
            this.savingsBalance = savingsBalance;
        }
    }
    /**
     * @return the annualInterestRate
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * @param newAnnualInterestRate the annualInterestRate to set
     */
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        if (newAnnualInterestRate >= 0.0 && newAnnualInterestRate <= 1.0) {
            annualInterestRate = newAnnualInterestRate;
        }
    }

    /**
     * @return the savingsBalance
     */
    public double getSavingsBalance() {
        return savingsBalance;
    }

    /**
     * @param savingsBalance the savingsBalance to set
     */
    public void setSavingsBalance(double savingsBalance) {
        if (savingsBalance >= 0.0) {
            this.savingsBalance = savingsBalance;
        }
    }
    
    /**
     * Calculates interest for one month (annual rate / 12) and adds to
     * savingsBalance
     */
    public void calculateMonthlyInterest() {
        savingsBalance = savingsBalance * (1 + annualInterestRate / 12);
    }
    
    
}
