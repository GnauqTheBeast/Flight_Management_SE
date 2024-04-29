/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Booking;
import Model.Flight;
import Model.Revenue;
import Model.Schedule;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Quang Nguyen
 */
public class DAO {
    private static String connectionString = "jdbc:sqlserver://localhost:1434;databaseName=test;user=sa;password=Duckie@01;encrypt=false";

    private Connection _connect;

    public DAO() {

        _connect = initializeDBConnection();
    }

    private Connection initializeDBConnection() {
        try {
            String password = "";
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("DB connected");
            return connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public List<Revenue> revenueByMonth() throws SQLException {
        List<Revenue> revenues = new ArrayList<>();
        String query = "SELECT YEAR(s.departureTime) AS Year, MONTH(s.departureTime) AS Month, SUM(b.receipt) AS Receipt FROM Booking b JOIN Schedule s ON b.scheduleId = s.id GROUP BY YEAR(s.departureTime), MONTH(s.departureTime) ORDER BY Year, Month;";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Revenue revenue = new Revenue();
                revenue.setYear(result.getInt("Year"));
                revenue.setMonth(result.getInt("Month"));
                revenue.setReceipt(result.getInt("Receipt"));
                revenues.add(revenue);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return revenues;
    }
    
    public List<Revenue> revenueByQuarter() throws SQLException {
        List<Revenue> revenues = new ArrayList<>();
        String query = "SELECT YEAR(s.departureTime) AS Year, CASE WHEN MONTH(s.departureTime) BETWEEN 1 AND 3 THEN 'Q1' WHEN MONTH(s.departureTime) BETWEEN 4 AND 6 THEN 'Q2' WHEN MONTH(s.departureTime) BETWEEN 7 AND 9 THEN 'Q3' ELSE 'Q4' END AS Quarter, SUM(b.receipt) AS Receipt FROM Booking b JOIN Schedule s ON b.scheduleId = s.id GROUP BY YEAR(s.departureTime), CASE WHEN MONTH(s.departureTime) BETWEEN 1 AND 3 THEN 'Q1' WHEN MONTH(s.departureTime) BETWEEN 4 AND 6 THEN 'Q2' WHEN MONTH(s.departureTime) BETWEEN 7 AND 9 THEN 'Q3' ELSE 'Q4' END ORDER BY Year, Quarter;";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Revenue revenue = new Revenue();
                revenue.setYear(result.getInt("Year"));
                revenue.setQuarter(result.getString("Quarter"));
                revenue.setReceipt(result.getInt("Receipt"));
                revenues.add(revenue);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return revenues;
    }
    
    public List<Revenue> revenueByYear() throws SQLException {
        List<Revenue> revenues = new ArrayList<>();
        String query = "SELECT YEAR(s.departureTime) AS Year, SUM(b.receipt) AS Receipt FROM Booking b JOIN Schedule s ON b.scheduleId = s.id GROUP BY YEAR(s.departureTime) ORDER BY Year;";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Revenue revenue = new Revenue();
                revenue.setYear(result.getInt("Year"));
                revenue.setReceipt(result.getInt("Receipt"));
                revenues.add(revenue);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return revenues;
    }
    
    public List<Revenue> revenueByFlightName(String flightName) throws SQLException {
        List<Revenue> revenues = new ArrayList<>();
        String query = "SELECT YEAR(s.departureTime) AS Year, CASE WHEN MONTH(s.departureTime) BETWEEN 1 AND 3 THEN 'Q1' WHEN MONTH(s.departureTime) BETWEEN 4 AND 6 THEN 'Q2' WHEN MONTH(s.departureTime) BETWEEN 7 AND 9 THEN 'Q3' ELSE 'Q4' END AS Quarter, MONTH(s.departureTime) AS Month, SUM(b.receipt) AS Receipt FROM Flight f JOIN Schedule s ON f.scheduleId = s.id JOIN Booking b ON b.scheduleId = s.id WHERE f.name = ?  GROUP BY YEAR(s.departureTime), MONTH(s.departureTime), CASE WHEN MONTH(s.departureTime) BETWEEN 1 AND 3 THEN 'Q1' WHEN MONTH(s.departureTime) BETWEEN 4 AND 6 THEN 'Q2' WHEN MONTH(s.departureTime) BETWEEN 7 AND 9 THEN 'Q3' ELSE 'Q4' END;";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            statement.setString(1, flightName);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Revenue revenue = new Revenue();
                revenue.setYear(result.getInt("Year"));
                revenue.setQuarter(result.getString("Quarter"));
                revenue.setMonth(result.getInt("Month"));
                revenue.setReceipt(result.getInt("Receipt"));
                revenues.add(revenue);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return revenues;
    }
    
    public List<Booking> getAllBooking() throws SQLException {
        List<Booking> allBooking = new ArrayList<>();
        String query = "select * from booking";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Booking booking = new Booking();
                booking.setId(result.getInt("id"));
                booking.setScheduleId(result.getInt("scheduleId"));
                booking.setCustomerId(result.getInt("customerId"));
                booking.setReceipt(result.getInt("Receipt"));
                allBooking.add(booking);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return allBooking;
    }
    
    public List<Schedule> getAllSchedule() throws SQLException {
        List<Schedule> allSchedule = new ArrayList<>();
        String query = "select * from schedule";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(result.getInt("id"));
                schedule.setGate(result.getString("gate"));
                schedule.setDepartureTime(result.getTimestamp("departureTime"));
                schedule.setDeparture(result.getString("departure"));
                schedule.setStatus(result.getString("status"));
                allSchedule.add(schedule);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return allSchedule;
    }
    
    public List<Flight> getAllFlight() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String query = "select * from flight";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Flight flight = new Flight();
                flight.setId(result.getInt("id"));
                flight.setName(result.getString("name"));
                flight.setDeparture(result.getString("departure"));
                flight.setArrival(result.getString("arrival"));
                flight.setDurationMinutes(result.getInt("durationMinutes"));
                flight.setScheduleId(result.getInt("scheduleId"));
                flights.add(flight);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return flights;
    }
}
