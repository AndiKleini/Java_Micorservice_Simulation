# Java_Microservice_Simulation
This repo contains a trivial simulation of microservices communicating via a dummy message bus. The dummy application sells concert tickets to employees so that 
a SellTicketService and a BookMoneyService need to interact properly. Services are realized as classes deriving from ServiceBase. 
The main problem ramps up ervices and connects them via MessageBus subscriptions, before two ticket sell messages are published.

## Challenge
Add a new service that writes a notification containing the employeeId and event's name to the console. The only code you are allowed to change resides in the main program, 
which is required as the new service needs to be launched somehow.

##Solution
You can find a solution on the add_prize_altering branch.

