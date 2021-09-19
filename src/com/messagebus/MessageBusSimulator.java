package com.messagebus;

import java.util.ArrayList;
import java.util.List;

public class MessageBusSimulator implements IMessageBus {

    List<IMessageConsumer> consumers = new ArrayList<IMessageConsumer>();

    @Override
    public void publish(MessageBase message) {
        consumers.forEach((consumer) -> consumer.consume(message));
    }

    @Override
    public void subscribe(IMessageConsumer consumer) {
        this.consumers.add(consumer);
    }
}
