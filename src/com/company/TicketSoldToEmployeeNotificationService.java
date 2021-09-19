package com.company;

import com.messagebus.IMessageBus;
import com.messagebus.MessageBase;
import com.messagebus.TicketSoldEvent;

public class TicketSoldToEmployeeNotificationService extends ServiceBase {

    TicketSoldToEmployeeNotificationService(IMessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void consume(MessageBase message) {
        if (message instanceof TicketSoldEvent ticketSoldEvent) {
            this.writeNote(ticketSoldEvent.getEmployee() + " retrieved ticket for " + ticketSoldEvent.getEventName());
        }
    }
}
