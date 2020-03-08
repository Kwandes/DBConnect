// Sample project for testing interaction with a AWS  RDS mySQL Database using Java
// Java 13, IntelliJ IDEA, mySQL 5.7.26 instance hosted on AWS RDS
// Dependency: mysql-connector.jar
// You have to download it and add the library to the project

import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://minecraft.net/";
        String user = "yes";
        String passwd = "credentials";

        String query = "SELECT * FROM exampleSchema.exampleTableUno;";

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, passwd);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println(rs.getMetaData().getTableName(1));

            while (rs.next())
            {
                System.out.println("ID: " + rs.getString("id") + " | " +
                                    "User: " + rs.getString("name") + " | " +
                                    "Status: " + rs.getString("status"));
            }

        } catch (SQLException e)
        {
            System.out.println(e);
        } catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
