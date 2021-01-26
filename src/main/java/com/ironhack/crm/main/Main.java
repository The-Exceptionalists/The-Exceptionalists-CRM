package com.ironhack.crm.main;

import com.ironhack.crm.utilities.Buffer;
import com.ironhack.crm.utilities.Output;

public class Main {
    public static void main(String[] args) {

//       CommandManager.printCommandList();
//        while(true) {
//            CommandManager.introduceCommand();
//        }


//        Buffer.setLocationOne("AC0000042");
//        Buffer.setLocationTwo("Peppino Impastato");
//        Buffer.setLocationThree("peppino@gmail.com");
//        Buffer.setLocationFour("Google");
//        Buffer.setLocationFive("+346654345");
//        Buffer.setLocationSix("");
//        Buffer.setLocationSeven("");
//        Buffer.setLocationEight("");


        Buffer.initStringsRepository();
        Buffer.insertStringIntoRepository("AC0000042", 10);
        Buffer.insertStringIntoRepository("Peppino Impastato", 11);
        Buffer.insertStringIntoRepository("peppino@gmail.com", 12);
        Buffer.insertStringIntoRepository("Google", 13);
        Buffer.insertStringIntoRepository("+346654345", 14);

        Buffer.setUpLayout();

        Buffer.insertItemSolo();
        Buffer.setPromptLineOne("Ti piace la pasta?");
        Buffer.insertCentralPromptPoints(1);

//        Buffer.insertItemListByThree(6, 1);

        Output.printScreen();

        //System.out.println(Validator.validateCommand("lookup opportunity"));

    }


}
