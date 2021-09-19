package com.company;

import com.messagebus.*;

public class SellTicketService extends ServiceBase {

    SellTicketService(IMessageBus messageBus){
        super(messageBus);
    }

    @Override
    public void consume(MessageBase message) {

        if (message instanceof SellTicketMessage sellTicketMessage) {
            this.writeNote("Check if ticket can be sold.");
            this.writeNote("Ticket can be sold.");
            this.writeNote("Ask for booking money.");
            this.messageBus.publish(
                    new BookMoneyMessage(
                            sellTicketMessage.getPrize(),
                            this.getAccountToEmployee(sellTicketMessage.getEmployeeId()),
                            sellTicketMessage.getEmployeeId(),
                            sellTicketMessage.getName()));
        }

        if (message instanceof MoneyBookedEvent moneyBookedEvent) {
            this.writeNote("Money booked event received.");
            this.writeNote("Complete ticket sell.");
            this.publish(
                    new TicketSoldEvent(
                            moneyBookedEvent.getEmployee(),
                            moneyBookedEvent.getEventName()));
        }

        if (message instanceof MoneyBookedFailedEvent moneyBookedFailedEvent) {
            this.writeNote("Money booked failed event received");
            this.writeNote("Cancel ticket sell");
            this.publish(
                    new TicketSoldFailedEvent(
                            moneyBookedFailedEvent.getEmployee(),
                            moneyBookedFailedEvent.getEventName()));
        }
    }

    private int getAccountToEmployee(String employeeId) {
        if (employeeId.equals("Robert_Superbowl_1")) {
            return 13;
        } else {
            return 12;
        }
    }
}
