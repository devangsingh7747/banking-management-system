package bank.management.system;

import java.sql.*;

public class Connn {

    Connection connection;
    Statement statement;

    public Connn() {

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem",
                    "root",
                    "Dev@ng7747"
            );

            statement = connection.createStatement();

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
