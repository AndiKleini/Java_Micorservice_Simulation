package com.messagebus;

public class SellTicketMessage extends MessageBase {
    private double prize;
    private String eventName;
    private String employeeId;


    public SellTicketMessage(double prize, String eventName, String employeeId) {
        this.prize = prize;
        this.eventName = eventName;
        this.employeeId = employeeId;
    }

    public String getName() { return this.eventName; }
    public double getPrize() { return this.prize; }
    public String getEmployeeId() { return employeeId; }
}
