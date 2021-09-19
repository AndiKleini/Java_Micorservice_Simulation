package com.company;

import com.messagebus.*;

public class SellTicketService extends ServiceBase {

    SellTicketService(IMessageBus messageBus){
        super(messageBus);
    }

    @Override
    public void consume(MessageBase message) {

        if (message instanceof SellTicketMessage) {
            this.writeNote("Check if ticket can be sold.");
            this.writeNote("Ticket can be sold.");
            this.writeNote("Ask for booking money.");
            this.messageBus.publish(new BookMoneyMessage());
        }

        if (message instanceof MoneyBookedEvent) {
            this.writeNote("Money booked event received.");
            this.writeNote("Complete ticket sell.");
            this.publish(new TicketSoldEvent());
        }

        if (message instanceof  MoneyBookedFailedEvent) {
            this.writeNote("Money booked failed event received");
            this.writeNote("Cancel ticket sell");
            this.publish(new TicketSoldFailedEvent());
        }
    }
}
