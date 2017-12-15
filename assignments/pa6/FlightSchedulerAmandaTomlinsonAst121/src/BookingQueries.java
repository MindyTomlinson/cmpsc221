
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingQueries {

    private Connection connection;
    private PreparedStatement selectAllBookings;
    private PreparedStatement selectBookingsByPassenger;
    private PreparedStatement selectBookingsByPassengerDay;
    private PreparedStatement selectBookingsByStatus;
    private PreparedStatement selectBookingsByDayStatus;
    private PreparedStatement selectBookingsByFlight;
    private PreparedStatement selectBookingsByFlightDayStatus;
    private PreparedStatement countBookingsByFlightDayStatus;
    private PreparedStatement updateBookingStatus;
    private PreparedStatement insertBooking;
    private PreparedStatement deleteBooking;
    private FlightQueries flightQueries = new FlightQueries();
    public static final int DUPKEY = 0;
    public static final int FAIL = -1;

    public BookingQueries() {

        try {
            connection = FSConnection.getConnection();

            selectAllBookings = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS");

            selectBookingsByPassenger = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS " +
                            "WHERE CUSTOMERNAME = ? " +
                            "ORDER BY DAY, FLIGHTNAME ASC");

            selectBookingsByPassengerDay = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS " +
                            "WHERE CUSTOMERNAME = ? AND Day = ? " +
                            "ORDER BY FLIGHTNAME");


            selectBookingsByStatus = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS " +
                            "WHERE STATUS = ?");

            selectBookingsByDayStatus = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS " +
                            "WHERE Day = ? AND Status = ?" + 
                            "ORDER BY FlightName, Position ASC");

            selectBookingsByFlight = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS " +
                            "WHERE FLIGHTNAME = ? " +
                            "ORDER BY POSITION ASC");

            selectBookingsByFlightDayStatus = connection.prepareStatement(
                    "SELECT * FROM BOOKINGS " +
                            "WHERE FlightName = ? AND Day = ? AND Status = ?" +
                            "ORDER BY POSITION ASC");

            countBookingsByFlightDayStatus = connection.prepareStatement(
                    "SELECT COUNT(*) AS TicketCount FROM BOOKINGS " +
                            "WHERE FlightName = ? AND Day = ? AND Status = ?");

            updateBookingStatus = connection.prepareStatement(
                    "UPDATE BOOKINGS " +
                            "SET STATUS = ? " +
                            "WHERE CUSTOMERNAME = ? AND FLIGHTNAME = ? AND DAY = ?");

            insertBooking = connection.prepareStatement(
                    "INSERT INTO BOOKINGS " +
                            "(CUSTOMERNAME, FLIGHTNAME, DAY, STATUS, POSITION) " +
                            "VALUES (?, ?, ?, ?, ?)");

            deleteBooking = connection.prepareStatement(
                    "DELETE FROM BOOKINGS " +
                            "WHERE FLIGHTNAME = ? AND DAY = ? AND CUSTOMERNAME = ?");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Booking> getAllBookings() {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = selectAllBookings.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public ArrayList<Booking> getBookingsByPassenger(String passengerName) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            selectBookingsByPassenger.setString(1, passengerName);
            resultSet = selectBookingsByPassenger.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public ArrayList<Booking> getBookingsByPassengerDay(String passengerName, LocalDate day) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            selectBookingsByPassengerDay.setString(1, passengerName);
            selectBookingsByPassengerDay.setDate(2, java.sql.Date.valueOf(day));
            resultSet = selectBookingsByPassengerDay.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public ArrayList<Booking> getTicketsByFlightDay(String flightName, LocalDate day) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            selectBookingsByFlightDayStatus.setString(1, flightName);
            selectBookingsByFlightDayStatus.setDate(2, java.sql.Date.valueOf(day));
            selectBookingsByFlightDayStatus.setInt(3, Booking.TICKETED);
            resultSet = selectBookingsByFlightDayStatus.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public ArrayList<Booking> getWaitlistByDay(LocalDate day) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            selectBookingsByDayStatus.setDate(1, java.sql.Date.valueOf(day));
            selectBookingsByDayStatus.setInt(2, Booking.WAITLIST);
            resultSet = selectBookingsByDayStatus.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public ArrayList<Booking> getWaitlistByFlightDay(String flightName, LocalDate day) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            selectBookingsByFlightDayStatus.setString(1, flightName);
            selectBookingsByFlightDayStatus.setDate(2, java.sql.Date.valueOf(day));
            selectBookingsByFlightDayStatus.setInt(3, Booking.WAITLIST);
            resultSet = selectBookingsByFlightDayStatus.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public ArrayList<Booking> getBookingsByFlight(String flightName) {

        ArrayList<Booking> bookings = new ArrayList<>();
        ResultSet resultSet;

        try {
            selectBookingsByFlight.setString(1, flightName);
            resultSet = selectBookingsByFlight.executeQuery();

            while (resultSet.next()) {
                bookings.add(new Booking(
                        resultSet.getString("CustomerName"),
                        resultSet.getString("FlightName"),
                        resultSet.getDate("Day").toLocalDate(),
                        resultSet.getInt("Status"),
                        resultSet.getLong("Position")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public int getRemainingSeatsCount(String flightName, LocalDate day) {

        int remainingSeats = 0; // Assume none by default
        int ticketedSeats = 0; // Assume none by default
        int flightSeats = flightQueries.getFlightSeats(flightName);

        try {
            countBookingsByFlightDayStatus.setString(1, flightName);
            countBookingsByFlightDayStatus.setDate(2, java.sql.Date.valueOf(day));
            countBookingsByFlightDayStatus.setInt(3, Booking.TICKETED);
            ResultSet resultSet = countBookingsByFlightDayStatus.executeQuery();
            if (resultSet.next()) {
                ticketedSeats = resultSet.getInt("TicketCount");
            }
            remainingSeats = flightSeats - ticketedSeats;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return remainingSeats;
    }

    public void convertWaitlistToTicket(Booking booking) {

        try {
            updateBookingStatus.setInt(1, Booking.TICKETED);
            updateBookingStatus.setString(2, booking.getPassengerName());
            updateBookingStatus.setString(3, booking.getFlightName());
            updateBookingStatus.setDate(4, java.sql.Date.valueOf(booking.getDay()));
            updateBookingStatus.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addBooking(String passengerName, String flightName, LocalDate day) {

        int status = Booking.WAITLIST; // Assume waitlist unless there are seats open
        if (getRemainingSeatsCount(flightName, day) > 0) { // 1 or more remaining seats
            status = Booking.TICKETED;
        }

        long position = Booking.calculatePosition();

        try {
            insertBooking.setString(1, passengerName);
            insertBooking.setString(2, flightName);
            insertBooking.setDate(3, java.sql.Date.valueOf(day));
            insertBooking.setInt(4, status);
            insertBooking.setLong(5, position);
            insertBooking.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            return DUPKEY; // Booking already exists
        }
        catch (SQLException e) {
            e.printStackTrace();
            return FAIL; // If failed
        }

        return status; // If successful, return whether booking was ticketed or waitlisted
    }

    public void deleteBooking(String flightName, LocalDate day, String passengerName) {

        try {
            deleteBooking.setString(1, flightName);
            deleteBooking.setDate(2, Date.valueOf(day));
            deleteBooking.setString(3, passengerName);
            deleteBooking.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> cancelBooking(String passengerName, LocalDate day) {

        // Returns arraylist of result messages for use in GUI
        ArrayList<String> results = new ArrayList<>();

        // Get all bookings on that day for that passenger
        ArrayList<Booking> bookings = getBookingsByPassengerDay(passengerName, day);

        for (Booking booking : bookings) {

            // Delete the booking
            deleteBooking(booking.getFlightName(), day, passengerName);
            String deleteMessage = String.format(
                    "Booking cancelled: Passenger %s on flight %s on %s",
                    booking.getPassengerName(),
                    booking.getFlightName(),
                    booking.getDay());
            results.add(deleteMessage);

            // If cancelled booking was ticketed, give next in line on waitlist the ticket
            if (booking.getStatus() == Booking.TICKETED) {

                ArrayList<Booking> waitlist = getWaitlistByFlightDay(booking.getFlightName(), day);

                if (!waitlist.isEmpty()) { // if waitlist NOT empty
                    Booking nextInLine = waitlist.get(0); // get next in line (earliest position)
                    convertWaitlistToTicket(nextInLine);

                    String updateMessage = String.format(
                            "Booking updated from waitlist to ticketed: Passenger %s on flight %s on %s",
                            nextInLine.getPassengerName(),
                            nextInLine.getFlightName(),
                            nextInLine.getDay());
                    results.add(updateMessage);
                }
            }
        }
        return results;
    }
}
