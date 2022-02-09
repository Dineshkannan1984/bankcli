# bankcli
Command line interface based bank application for ease usage
Application Name : Interactive Bank using  Command Line Interface

 

Requirement :Develop Web Application in Java spring boot as backend and React as frontend to simulate interaction with a retail bank.

 

How to execute the program :

Download the source code and execute below command for maven download
$mvn Clean install

Start the spring boot application using XxxCliApplication.java as stanadlone and spring shell will open
 

 

Assumption :

 

Only one user account can exist.
User account  is case insensitive.
No currency is attached to top up amount.
As the application has to be interactive , was deployed using spring-shell.
User must login to Topup and Transfer.
Amount can be transferred only to existing account
Amount cannot be transferred to same account
 

Testing Performed using Spring shell:

 

shell:>login dinesh

Hello, dinesh!

Your balance is 0

shell:>topup 500

Your balance is 500

shell:>login kannan

Hello, kannan!

Your balance is 0

shell:>topup 900

Your balance is 900

shell:>pay Dinesh 100

Transferred 100 to Dinesh

Your balance is 800

shell:>login Dinesh

Hello, Dinesh!

Your balance is 600

shell:>login dinesh

Hello, dinesh!

Your balance is 600
