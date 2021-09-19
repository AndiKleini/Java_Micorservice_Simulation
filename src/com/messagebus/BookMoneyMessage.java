package com.messagebus;

public class BookMoneyMessage extends MessageBase {
    private final double amount;
    private final int accountId;
    private String eventName;
    private String employeeId;

    public BookMoneyMessage(
            double amount,
            int accountId,
            String eventName,
            String employeeId) {

        this.amount = amount;
        this.accountId = accountId;
        this.eventName = eventName;
        this.employeeId = employeeId;
    }

    public double getAmount() {
        return amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
