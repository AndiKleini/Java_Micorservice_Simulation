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
        System.out.println("Sell Metallica ticket for Andreas_Kleibichler_12");
        messageBus.publish(new SellTicketMessage(12.5, "Metallica", "Andreas_Kleinbichler_12"));

        System.out.println("Sell Iron Maiden ticket for Robert_Superbowl_1");
        messageBus.publish(new SellTicketMessage(12.5, "MIron Maiden", "Robert_Superbowl_1"));
    }
}
