//package com.CezaryZal.production.testDB;
//
//
//import java.sql.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//public class ConnectDB {
//    public static void main(String[] args) {
//
//        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?useSSL=false";
////        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?useSSL=false&serverTimezone=UTC";
////        final String JDB_URL = "jdbc:mysql://localhost:3306/health_calendar?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//        final String USENAME = "hbstudent";
//        final String PASSWORD = "HBstudent!123";
//
//        try (Connection connection = DriverManager.getConnection(JDB_URL, USENAME, PASSWORD)) {
//            System.out.println("Test connect");
//
//            LocalDate currentDateMin = LocalDate.of(2018, 9, 23);
//            LocalDate currentDateMax = LocalDate.of(2018, 9, 25);
//
////            PreparedStatement stat = connection.prepareStatement("SELECT * FROM meal where date_time='2018-09-24 03:33' ");
////            PreparedStatement stat = connection.prepareStatement(
////                    "SELECT * FROM meal where date_time<='2018-09-25' AND date_time>='2018-09-23'");
//            PreparedStatement stat = connection.prepareStatement(
//                    "SELECT * FROM meal where date_time<=? AND date_time>=?");
//
//            stat.setDate(1, Date.valueOf(currentDateMax));
//            stat.setDate(2, Date.valueOf(currentDateMin));
//
//            ResultSet resultSet = stat.executeQuery();
//
//
//            while (resultSet.next()) {
//                System.out.println("id: " + resultSet.getString("id"));
//                System.out.println("date: " + resultSet.getTimestamp("date_time"));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
