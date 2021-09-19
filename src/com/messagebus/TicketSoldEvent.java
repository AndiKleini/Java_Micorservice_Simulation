package com.messagebus;

public class TicketSoldEvent extends MessageBase {
    private String employee;
    private String eventName;

    public TicketSoldEvent(String employee, String eventName) {
        this.employee = employee;
        this.eventName = eventName;
    }

    public String getEmployee() {
        return employee;
    }

    public String getEventName() {
        return eventName;
    }
}
