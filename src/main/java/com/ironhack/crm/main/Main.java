package com.ironhack.crm.main;

import com.ironhack.crm.utilities.Buffer;
import com.ironhack.crm.utilities.Output;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {

//       CommandManager.printCommandList();
//        while(true) {
//            CommandManager.introduceCommand();
//        }


        Buffer.setLocationOne("AC0000042");
        Buffer.setLocationTwo("Peppino Impastato");
        Buffer.setLocationThree("peppino@gmail.com");
        Buffer.setLocationFour("Google");
        Buffer.setLocationFive("+346654345");
        Buffer.setLocationSix("");
        Buffer.setLocationSeven("");
        Buffer.setLocationEight("");



        Buffer.insertCentralBox();
        Buffer.insertUserName();
        Buffer.insertCentralPrompt();
        Buffer.insertLogo();
        Buffer.insertAppName();
        Buffer.insertCompanyName();
        Buffer.insertSideBox();
        Buffer.insertItemListByThree(6, 1);

        Output.printScreen();

        //System.out.println(Validator.validateCommand("lookup opportunity"));

    }
}
