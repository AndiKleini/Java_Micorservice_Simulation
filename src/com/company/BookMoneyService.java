package com.company;

import com.messagebus.BookMoneyMessage;
import com.messagebus.MessageBase;
import com.messagebus.IMessageBus;
import com.messagebus.MoneyBookedEvent;

public class BookMoneyService extends ServiceBase {
    BookMoneyService(IMessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void consume(MessageBase message) {
        if (message instanceof BookMoneyMessage) {
            this.writeNote("BookMoney message received.");
            this.writeNote("Start booking money.");
            this.writeNote("Money was booked");
            this.publish(new MoneyBookedEvent());
        }
    }
}
