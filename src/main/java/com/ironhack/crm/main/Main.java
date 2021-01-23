package com.ironhack.crm.main;

import com.ironhack.crm.manager.CommandManager;

public class Main {
    public static void main(String[] args) {
        CommandManager.setCommandList();
        while (true) {
            CommandManager.introduceCommand();
        }
    }
}
