package com.ironhack.crm.main;

import com.ironhack.crm.manager.CommandManager;
import com.ironhack.crm.utilities.*;
import com.ironhack.crm.enums.*;
import com.ironhack.crm.utilities.Buffer;
import com.ironhack.crm.utilities.Output;

import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        Buffer.initStringsRepository();
        State.restoreState();
//        CommandManager.printCommandList();
        while (true) {
            CommandManager.introduceCommand();
        }

       /*CommandManager.printCommandList();
        while(true) {
            CommandManager.introduceCommand();
        }*/


//
//
//        Buffer.initStringsRepository();
//        Buffer.insertStringIntoRepository(Buffer.getResultItem() + "1", 7);
//        Buffer.insertStringIntoRepository("* AC0000042", 10);
//        Buffer.insertStringIntoRepository("* Peppino Impastato", 11);
//        Buffer.insertStringIntoRepository("* peppino@gmail.com", 12);
//        Buffer.insertStringIntoRepository("* Google", 13);
//        Buffer.insertStringIntoRepository("* +34665423345", 14);
//
//        Buffer.setUpLayout();
//
//        Buffer.insertOptionsAnchors(1);
//        Buffer.insertStringIntoRepository("Save", 20);
//
//        Buffer.insertItemSolo();
//        Buffer.setPromptLineOne("Ti piace la pasta?");
//        Buffer.insertCentralPromptPoints(1);
//
////        Buffer.insertItemListByThree(6, 1);
//
//        Output.printScreen();
//
//        //System.out.println(Validator.validateCommand("lookup opportunity"));

    }


}
