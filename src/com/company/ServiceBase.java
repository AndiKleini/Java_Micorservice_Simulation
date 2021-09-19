package com.company;

import com.messagebus.IMessageBus;
import com.messagebus.IMessageConsumer;
import com.messagebus.MessageBase;

public abstract class ServiceBase implements IMessageConsumer {
    protected IMessageBus messageBus;

    ServiceBase(IMessageBus messageBus) {
        this.messageBus = messageBus;
        messageBus.subscribe(this);
    }

    protected void publish(MessageBase message) {
        this.messageBus.publish(message);
    }

    protected void writeNote(String note) {
        System.out.println(this.getClass().getName() + " -> " + note);
    }
}
