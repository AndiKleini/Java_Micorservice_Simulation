package com.messagebus;

public interface IMessageConsumer {
    public void consume(MessageBase message);
}
