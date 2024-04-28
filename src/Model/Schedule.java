/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author Quang Nguyen
 */
public class Schedule {
    private int id;
    private String gate;
    private Timestamp departureTime;
    private String status;

    public Schedule(int id, String gate, Timestamp departureTime, String status, String aircraft, int flightId) {
        this.id = id;
        this.gate = gate;
        this.departureTime = departureTime;
        this.status = status;
        this.aircraft = aircraft;
        this.flightId = flightId;
    }

    public Schedule() {
    }
    private String aircraft;
    private int flightId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}