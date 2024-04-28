/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Quang Nguyen
 */
public class Booking {
    private int id;
    private int flightId;
    private int customerId;
    private int receipt;

    // Constructor
    public Booking(int id, int flightId, int customerId, int receipt) {
        this.id = id;
        this.flightId = flightId;
        this.customerId = customerId;
        this.receipt = receipt;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }

    // toString method to print booking details
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", customerId=" + customerId +
                ", receipt=" + receipt +
                '}';
    }

    // Example of how to use the Booking class
    public static void main(String[] args) {
        Booking booking1 = new Booking(1, 101, 1, 12345);
        System.out.println(booking1);
    }
}