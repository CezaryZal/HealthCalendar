package com.CezaryZal.testDB;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConnectDB {
    public static void main(String[] args) {

        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?useSSL=false";
//        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?useSSL=false&serverTimezone=UTC";
//        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        final String USENAME = "hbstudent";
        final String PASSWORD = "HBstudent!123";

        try (Connection connection = DriverManager.getConnection(JDB_URL, USENAME, PASSWORD)) {

            System.out.println("Test connect");

            int userId = 2;
            PreparedStatement stat = connection.prepareStatement("SELECT date FROM body_size WHERE user_id=?");
            stat.setInt(1, userId);


            ResultSet resultSet = stat.executeQuery();


            while (resultSet.next()) {
                System.out.println(resultSet.getString("date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
