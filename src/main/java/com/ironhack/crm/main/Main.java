package com.ironhack.crm.main;

import com.ironhack.crm.manager.CommandManager;
import com.ironhack.crm.utilities.*;

public class Main {
    public static void main(String[] args) {
        State.restoreState();
        CommandManager.setCommandList();
        while (true) {
            CommandManager.introduceCommand();
        }
    }
}
