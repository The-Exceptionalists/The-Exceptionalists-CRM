package com.ironhack.crm.main;

import com.ironhack.crm.manager.CommandManager;
import com.ironhack.crm.utils.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {

       /*CommandManager.printCommandList();
        while(true) {
            CommandManager.introduceCommand();
        }*/

        System.out.println(Validator.validateCommand("lookup opportunity"));

    }
}
