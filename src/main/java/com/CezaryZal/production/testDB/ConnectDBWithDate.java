//package com.CezaryZal.production.testDB;
//
//
//import java.sql.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//public class ConnectDBWithDate {
//    public static void main(String[] args) {
//
//        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?useSSL=false&serverTimezone=UTC";
////        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//        final String USENAME = "hbstudent";
//        final String PASSWORD = "HBstudent!123";
//
//        try (Connection connection = DriverManager.getConnection(JDB_URL, USENAME, PASSWORD)) {
//
//            System.out.println("Test connect");
//
//            //dziala
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar calendar = new GregorianCalendar(2018,4,24);
//            System.out.println(sdf.format(calendar.getTime()));
//            //dziala
//            String tmpDate = "2018-05-23";
//            //dziala, lecz lepiej stosować LocalDate
//            SimpleDateFormat foo = new SimpleDateFormat("dd-MM-yyyy");
//            Date d = foo.parse("23-05-2018");
//            System.out.println(foo.format(d));
//
//
//
//            PreparedStatement stat = connection.prepareStatement("SELECT * FROM day WHERE dateRecord=?");
//
//            stat.setString(1, sdf.format(d));
//            ResultSet resultSet = stat.executeQuery();
//
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("id"));
//            }
//
//        } catch (SQLException | ParseException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//}
