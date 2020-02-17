import java.sql.*;

public class DatabaseTesting {
    /*
    Data base testing in java is a 4 step process
    1. Associate the Connector jar file for the database (mySql jar is associated here) and load the driver using the Class.forName method
    2. Create the connection object using DriverManager.getConnection method (will return connection object)
    3. Create the statement object and pass the query in statementObj.executeQuery method => Returns result set
    4. Retrieve the results from the result set
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver"); //loads the driver for our next statement

        //pass the connection string for MySql database. Returns connection object to create the statement
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seleniumpractice", "root", "Colb@121");

        Statement smt = con.createStatement(); //Returns statement to execute query

        ResultSet rs = smt.executeQuery("select FIRSTNAME from employeeInfo");

        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME"));
        }

    }
}
