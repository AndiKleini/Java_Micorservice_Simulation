package com.messagebus;

public interface IMessageBus {
    public void publish(MessageBase message);
    public void subscribe(IMessageConsumer consumer);
}
