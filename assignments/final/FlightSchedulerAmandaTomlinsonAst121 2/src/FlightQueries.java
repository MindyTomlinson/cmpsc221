import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FlightQueries {

    private Connection connection;
    private PreparedStatement selectByFlight;
    private PreparedStatement selectAllFlights;
    private PreparedStatement insertNewFlight;
    private PreparedStatement deleteFlight;
    public static final int DUPKEY = 0;
    public static final int FAIL = -1;

    public FlightQueries() {
        try {
            connection = FSConnection.getConnection();

            selectAllFlights = connection.prepareStatement(
                    "SELECT * FROM FLIGHTS "
                            + "ORDER BY NAME ASC");

            selectByFlight = connection.prepareStatement(
                    "SELECT * FROM FLIGHTS " +
                            "WHERE NAME = ?");

            insertNewFlight = connection.prepareStatement(
                    "INSERT INTO FLIGHTS (NAME, SEATS) " +
                            "VALUES (?, ?)");

            deleteFlight = connection.prepareStatement(
                    "DELETE FROM FLIGHTS " +
                            "WHERE Name = ?");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllFlightNames() {

        ArrayList<String> flights = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = selectAllFlights.executeQuery();

            while (resultSet.next()) {
                flights.add(resultSet.getString("Name"));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    public ArrayList<Flight> getAllFlights() {

        ArrayList<Flight> flights = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = selectAllFlights.executeQuery();

            while (resultSet.next()) {
                flights.add(new Flight(
                        resultSet.getString("Name"),
                        resultSet.getInt("Seats")));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    public int getFlightSeats( String flightName ) {

        int seats = 0;
        ResultSet resultSet;

        try {
            selectByFlight.setString(1, flightName);
            resultSet = selectByFlight.executeQuery();
            resultSet.next();
            seats = resultSet.getInt("Seats");
            return seats;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return seats;
    }

    public int addFlight(Flight flight) {
        int result;
        try {
            insertNewFlight.setString(1, flight.getName());
            insertNewFlight.setInt(2, flight.getSeats());
            result = insertNewFlight.executeUpdate(); // 1 if flight added
        }
        catch (SQLIntegrityConstraintViolationException e) {
            result = DUPKEY; // Flight already exists
        }

        catch (SQLException e) {
            e.printStackTrace();
            result = FAIL; // Failed
        }

        return result;
    }

    public void deleteFlight(String flightName) {

        try {
            deleteFlight.setString(1, flightName);
            deleteFlight.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> dropFlight(String flightName) {

        ArrayList<String> results = new ArrayList<>();
        BookingQueries bookingQueries = new BookingQueries();

        // Get all bookings on that flight (across all days), ordered by position (earliest 1st)
        ArrayList<Booking> bookings = bookingQueries.getBookingsByFlight(flightName);

        // Remove the flight from the Flights table
        deleteFlight(flightName);

        // Get all remaining flights
        ArrayList<String> altFlightNames = getAllFlightNames();

        for (Booking booking: bookings) {

            // Get the booking's day and passenger
            LocalDate day = booking.getDay();
            String passengerName = booking.getPassengerName();

            // Delete the booking
            bookingQueries.deleteBooking(flightName, day, passengerName);

            // Report the deleted booking
            results.add(String.format("Booking deleted: Passenger %s on flight %s on %s",
                    passengerName, flightName, day));

            // Keep track of whether we were able to rebook or not
            boolean isRebooked = false;

            for (String altFlightName : altFlightNames) {

                if (!isRebooked) { // If not already rebooked

                    int openSeatsOnAltFlight = bookingQueries.getRemainingSeatsCount(altFlightName, day);

                    if (openSeatsOnAltFlight > 0) {

                        bookingQueries.addBooking(passengerName, altFlightName, day);
                        isRebooked = true;
                        results.add(String.format(
                                "Passenger rebooked: Passenger %s on flight %s on %s",
                                passengerName, altFlightName, day));
                    }
                }
            }

            if (!isRebooked) { // If not rebooked after looking through all alt flights

                results.add(String.format("No rebooking available: Passenger %s on %s",
                        passengerName, day));
            }
        }
        return results;
    }
}
