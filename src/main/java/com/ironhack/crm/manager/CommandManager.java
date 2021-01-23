package com.ironhack.crm.manager;

import com.ironhack.crm.enums.Status;
import com.ironhack.crm.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    private List<String> commandList;


    public List<String> getCommandList() {
        return commandList;
    }

    public void introduceCommand() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        if (!Validator.validateCommand(command)) throw new IllegalArgumentException();
        processCommand(command);
    }

    public void processCommand(String command) {
        String[] words = command.toLowerCase().split(" ");
        switch (words[0]) {
            case "new" -> createObject(words[1]);
            case "show" -> showList(words[1]);
            case "convert" -> convertLeadToOpportunity(Integer.parseInt(words[1]));
            case "lookup" -> showObject(words[1], Integer.parseInt(words[2]));
            case "close-won" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_WON);
            case "close-lost" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_LOST);
        }
    }

    private void closeOpportunity(int id, Status closedLost) {
        
    }

    private void convertLeadToOpportunity(int parseInt) {

    }

    private void createObject(String word) {

    }

    public void showList(String objectType) {

    }

    public void showObject(String objectType, int id) {

    }

    public void setCommandList() {
        commandList = new ArrayList<>();
        commandList.add("New Lead : Add a new Lead");
        commandList.add("Show Leads : Shows a list of all the Leads");
        commandList.add("Convert <id> : Converts a Lead into an Opportunity");
        commandList.add("Lookup Opportunity <id> : Shows an Opportunity.");
        commandList.add("Close-Won <id> : Closes an Opportunity as won.");
        commandList.add("Close-Lost <id> : Closes an Opportunity as lost.");
    }

}
