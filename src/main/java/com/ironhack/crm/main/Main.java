package com.ironhack.crm.main;

import com.ironhack.crm.manager.CommandManager;
import com.ironhack.crm.utils.Validator;

public class Main {
    public static void main(String[] args) {

       CommandManager.printCommandList();
        while(true) {
            CommandManager.introduceCommand();
        }

    }
}
