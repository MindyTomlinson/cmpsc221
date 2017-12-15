import java.time.LocalDate;

public class Booking {

    private String passengerName;
    private String flightName;
    private LocalDate day;
    private int status;
    private long position;
    public static final int TICKETED = 1;
    public static final int WAITLIST = 2;

    public Booking(String passengerName, String flightName, LocalDate day, int status, long position) {
        this.passengerName = passengerName;
        this.flightName = flightName;
        this.day = day;
        this.status = status;
        this.position = position;
    }

    public Booking(String passengerName, String flightName, LocalDate day, int status) {
        this.passengerName = passengerName;
        this.flightName = flightName;
        this.day = day;
        this.status = status;
        this.position = calculatePosition(); // If no position, calculate from current time
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if ((status == Booking.TICKETED) || (status == Booking.WAITLIST)) {
            this.status = status;
        }
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public static long calculatePosition() {
        return System.currentTimeMillis();
    }

    @Override
    public String toString() {

        String statusText = "Unknown";
        if (status == Booking.TICKETED) {
            statusText = "Ticketed";
        }
        if (status == Booking.WAITLIST) {
            statusText = "Waitlist";
        }

        return String.format("%s: passenger %s, flight %s on %s, position %d",
                statusText, passengerName, flightName, day, position);
    }
}
