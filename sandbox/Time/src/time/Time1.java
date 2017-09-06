package time;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class Time1 {
    private int hour;
    private int minute;
    private int second;
    
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException(
                "Hour out of range (0-23 accepted)");
        }
        else if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException(
                "Minute out of range (0-59 accepted)");
        }
        else if (second < 0 || second >= 60) {
            throw new IllegalArgumentException(
                "Second out of range (0-59 accepted");
        }
        else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }
    
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    public String toString() {
        return String.format("%d:%02d:%02d %s", 
                ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute,
                second,
                (hour >= 12 ? "PM" : "AM"));
    }
    
    public static void main(String[] args) {
        Time1 time1 = new Time1();
        // acceptable time
        time1.setTime(13, 28, 5);
        System.out.println("Print in universal format (hh:mm:ss):");
        System.out.println(time1.toUniversalString());
        System.out.println("Print in normal format (h:mm:ss AM/PM):");
        System.out.println(time1.toString());
        // unacceptable time
        try {
            time1.setTime(99,99,99);
        }
        catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n", e.getMessage());
        }
        
    }
}
