package com.company;

import com.messagebus.MessageBusSimulator;
import com.messagebus.SellTicketMessage;

public class Main {

    public static void main(String[] args) {

        // launch the microservice simulation
	    var messageBus = new MessageBusSimulator();
        var sellTicketService = new SellTicketService(messageBus);
        var bookMoneyService = new BookMoneyService(messageBus);

        // trigger the sell of a ticket
        messageBus.publish(new SellTicketMessage());
    }
}
