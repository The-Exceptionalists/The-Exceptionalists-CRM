# The Exceptionalists CRM

The Exceptionalists CRM is  a terminal-based Customer Relationship Manager that allows you to track leads, convert them into opportunities and many more features! 

Developed in bright 16-bit colors, you can easily store all you customer-related data and navigate through a fancy interface. 

## Installation

1. Download the proyect from the repository.

2. Open the directory as a project on a IDE as IntelliJ.

3. Run the Main.java file on the path:

```bash
 ./src/com/ironhack/rpg_simulator/main
```

## Functionalities

- **NEW LEAD:** Use this command to create new leads. The console will prompt you with the information needed.
- **SHOW <objectInPlural>** : Write "Show + any type of object (Account, Lead, Contact, Opportunity)" and you will be shown a list of all the objects of that class stored in the database.
- **CONVERT <ID>:** Enter convert + the id of a lead and it will be converted into an opportunity.
- **LOOKUP <Object> <id>:** Write the type of object you are searching and the specific id and all its information will be shown on screen.
- **CLOSE-WON <id>**: Closes an opportunity and marks it  as won. 
- **CLOSE-LOST <id>**: Closes an opportunity and marks it  as lost.
- **EXIT:** Write exit to save your database and terminate the session.

## Diagrams

- Case Diagram: https://github.com/The-Exceptionalists/The-Exceptionalists-CRM/blob/develop/src/main/resources/CRM-UseCase-Diagram.jpg
- Class Diagram: https://github.com/The-Exceptionalists/The-Exceptionalists-CRM/blob/develop/src/main/resources/CRM_Exceptionalists.jpeg

## Usage

The application starts with a fancy layout where a list of all the commands is shown in a window at the right side. The central window will contain the information of the objects the user wants to check, while the window at the bottom will prompt the required values in some of the operations. 

**The navigation system in this project is pretty straight-forward:** the user has to enter a command from the list, and the application will prompt the user with the required values while specifying them in the prompt window.  Each time the user enters an incorrect command or incorrect value, the user will be informed and asked to enter the command or value correctly.

## Screenshots

![alt text]('URL')

## Authors
**The Excepcionalist Team**: Adrià López, Jaume Sánchez, Salvatore Corsaro, Antonio Navarro, Iván Trujillo.
