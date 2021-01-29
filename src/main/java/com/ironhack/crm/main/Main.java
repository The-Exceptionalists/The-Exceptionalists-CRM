package com.ironhack.crm.main;

import com.ironhack.crm.manager.CommandManager;
import com.ironhack.crm.utilities.*;
import com.ironhack.crm.enums.*;
import com.ironhack.crm.utilities.Buffer;
import com.ironhack.crm.utilities.Output;

import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        Output.introResolutionAlert();
        Buffer.initStringsRepository();
        State.restoreState();
        while (true) {
            CommandManager.introduceCommand();
        }
    }
}
