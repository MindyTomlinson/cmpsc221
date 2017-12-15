import java.sql.*;
import java.util.ArrayList;

public class PassengerQueries {

    private Connection connection;
    private PreparedStatement selectAllPassengers;
    private PreparedStatement insertNewPassenger;
    public static final int DUPKEY = 0;
    public static final int FAIL = -1;

    public PassengerQueries() {
        try {
            connection = FSConnection.getConnection();

            selectAllPassengers = connection.prepareStatement(
                    "SELECT * FROM CUSTOMERS "
                            + "ORDER BY NAME ASC");

            insertNewPassenger = connection.prepareStatement(
                    "INSERT INTO CUSTOMERS (NAME) VALUES (?)"
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllPassengers() {

        ArrayList<String> customers = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = selectAllPassengers.executeQuery();

            while (resultSet.next()) {
                customers.add(resultSet.getString("Name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public int addPassenger(String name) {
        int result;
        try {
            insertNewPassenger.setString(1, name);
            result = insertNewPassenger.executeUpdate(); // 1 if passenger added
        }
        catch (SQLIntegrityConstraintViolationException e) {
            result = DUPKEY; // Passenger already exists
        }
        
        catch (SQLException e) {
            e.printStackTrace();
            result = FAIL; // Failed
        }

        return result;
    }
}
