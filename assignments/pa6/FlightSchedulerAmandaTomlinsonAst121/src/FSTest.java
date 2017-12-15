import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FSTest {


    public static void main(String[] args) throws SQLException {

        FSConnection connection = new FSConnection();
        PassengerQueries passengerQueries = new PassengerQueries();
        FlightQueries flightQueries = new FlightQueries();
        DayQueries dayQueries = new DayQueries();
        BookingQueries bookingQueries = new BookingQueries();

//        // Get All Passengers
//        System.out.println("Passengers Before:");
//        System.out.println(passengerQueries.getAllPassengers());
//
//        // Add passenger
//        passengerQueries.addPassenger("Mindy Tomlinson");
//        passengerQueries.addPassenger("Amber Miller");
//        System.out.println("Passengers After:");
//        System.out.println(passengerQueries.getAllPassengers());
//
//        // Get All Flights
//        System.out.println("All Flights:");
//        System.out.println(flightQueries.getAllFlightNames());
//
//        // Get Flight F101's seats
//        System.out.println("How many seats are on flight F101?");
//        System.out.println(flightQueries.getFlightSeats("F101"));

//        System.out.println("July 3, 2017");
//        LocalDate day1 = LocalDate.of(2017, 7, 3);
//        System.out.println(day1);
//
//        System.out.println("July 33, 2017");
//        LocalDate day2 = LocalDate.of(2017, 7, 33);
//        System.out.println(day2);

//        // Add Day
//        System.out.println("Add day 11/22/2017:");
//        LocalDate day = LocalDate.of(2017, 11, 22);
//        dayQueries.addDay(day);
//
//        // Get All Days
//        System.out.println("Get Days");
//        System.out.println(dayQueries.getAllDays());

//        // Add Flight
//        System.out.println("Add flight H303 with 2 seats");
//        flightQueries.addFlight(new Flight("H303", 2));
//
//        // Get All Flights
//        System.out.println("Get Flights");
//        System.out.println(flightQueries.getAllFlights());

        // Get all Bookings
//        System.out.println("Get Bookings:");
//        System.out.println(bookingQueries.getAllBookings());


//        int p1 = passengerQueries.addPassenger("Mindy Tomlinson");
//        passengerQueries.addPassenger("Sue Jury");
//        passengerQueries.addPassenger("Craig Scott");
//        passengerQueries.addPassenger("Jon David");

        // Add bookings
//        int result1 = bookingQueries.addBooking(
//                "Kait Hollinger", "F101",
//                LocalDate.of(2017,11,8)
//        );
//
//        int result2 = bookingQueries.addBooking(
//                "Jon David", "H303",
//                LocalDate.of(2017, 11, 8)
//        );

        // Cancel Kait's bookings on 11-8-2017
//        ArrayList<String> results = bookingQueries.cancelBooking(
//                "Kait Hollinger",
//                LocalDate.of(2017, 11, 8));

//        // Add flight F101
//        flightQueries.addFlight(new Flight("F101", 2));
//
//        // Book
//        bookingQueries.addBooking(
//                "Kait Hollinger", "F101",
//                LocalDate.of(2017, 11, 8));
//
//        bookingQueries.addBooking(
//                "Craig Scott", "H303",
//                LocalDate.of(2017, 11, 8));
//
//        bookingQueries.addBooking(
//                "Mindy Tomlinson", "H303",
//                LocalDate.of(2017, 11, 8));

        // Drop flight H303
//        ArrayList<String> results = flightQueries.dropFlight("H303");
//
//        // Print results
//        System.out.println("Results of dropping flight H303");
//        results.forEach(result -> System.out.println(result));

        // Get all bookings
//        System.out.println("Get all bookings:");
//        ArrayList<Booking> bookings = bookingQueries.getAllBookings();
//        bookings.forEach(booking -> System.out.println(booking));

//        // Get Kait's bookings
//        System.out.println("Get bookings for Kait:");
//        ArrayList<Booking> kaitBookings = bookingQueries.getBookingsByPassenger("Kait Hollinger");
//        kaitBookings.forEach(booking -> System.out.println(booking));

        // How many seats left on flight F101?
//        System.out.println("Seats on flight F101:");
//        int f101Seats = flightQueries.getFlightSeats("F101");
//        System.out.println(f101Seats);
//
//        System.out.println("Seats available on flight F101");
//        int f101RemainingSeats = bookingQueries.getRemainingSeatsCount("F101", LocalDate.of(2017, 11, 8));
//        System.out.println(f101RemainingSeats);

        // Try to book on flight F101
//        System.out.println("Book open seat on F101:");
//        int result = bookingQueries.addBooking(
//                "G202",
//                LocalDate.of(2017, 11, 8),
//                "Jason Cabinda");
//        System.out.println("Result = " + result);
//        System.out.println("Get all bookings (after):");
//        ArrayList<Booking> bookings = bookingQueries.getAllBookings();
//        bookings.forEach(i -> System.out.println(i));

//        ArrayList<Booking> bookings = bookingQueries.getTicketsByFlightDay(
//                "F101",
//                LocalDate.of(2017, 11, 8));
//
//        bookings.forEach(i -> System.out.println(i));
    }
}
