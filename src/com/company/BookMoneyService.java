package com.company;

import com.messagebus.*;

public class BookMoneyService extends ServiceBase {

    BookMoneyService(IMessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void consume(MessageBase message) {
        if (message instanceof BookMoneyMessage bookMoneyMessage) {
            this.writeNote("BookMoney message received.");
            this.writeNote("Start booking money.");
            this.writeNote("Checking if money can be booked.");
            if (!this.tryBookMoney(bookMoneyMessage.getAccountId())) {
                this.writeNote("Money was not booked.");
                this.publish(
                        new MoneyBookedFailedEvent(
                                bookMoneyMessage.getEmployeeId(),
                                bookMoneyMessage.getEventName()));
            } else {
                this.writeNote("Money was booked");
                this.publish(
                        new MoneyBookedEvent(
                                bookMoneyMessage.getEmployeeId(),
                                bookMoneyMessage.getEventName()));
            }
        }
    }

    private Boolean tryBookMoney(int accountId) {
        return accountId != 13;
    }
}
