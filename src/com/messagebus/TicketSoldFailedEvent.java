package com.messagebus;

public class TicketSoldFailedEvent extends MessageBase {
    private String employee;
    private String eventName;

    public TicketSoldFailedEvent(String employee, String eventName) {
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
