package com.ironhack.crm.utilities;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Lead;
import com.ironhack.crm.classes.Opportunity;

import java.util.Arrays;

public class Buffer {


    /**
     * boxes dimension
     * logo 4*4
     * app_name 20
     * company_name 20
     * username 20
     * central_box 78*8 (probably will need to think of a way to make it scroll)
     * side_box 20*15
     * prompt_box 78*4
     */

    static char[][] screenBuffer = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}

    };



    private static String singleSpace = " ";
    private static String appName = singleSpace + "DÉJÀ VU: your console CRM ";
    private static String companyName = singleSpace + "GlobalService Co.";
    private static String userName = singleSpace + "IronHacker";
    private static String currentLanguage = singleSpace + "En";
    private static String promptLineOne = "";
    private static String promptLineTwo = "";
    private static String resultItem = "Result ";
    private static String appVersion = "ver: 1.0";



    private static String[] stringsRepository;

    public static void initStringsRepository(){
        stringsRepository = new String[60];
        Arrays.fill(stringsRepository, "");
    }

    public static void insertStringIntoRepository(String str, int index){
        if (index > stringsRepository.length -1 || index < 0){
            throw new IllegalArgumentException();
        }
        stringsRepository[index] = str;
    }

    public static String getStringFromRepository(int index){
        if (index > stringsRepository.length -1  || index < 0){
            throw new IllegalArgumentException();
        }
        return stringsRepository[index];
    }

    public static void resetScreenBuffer(){
        for (int i = 0; i < Buffer.screenBuffer.length; i++) {
            for (int j = 0; j < Buffer.screenBuffer[i].length; ++j)
                screenBuffer[i][j] = ' ';
        }
    }


    public static void printSize() {
        System.out.println("Map size:");
        System.out.println("w: " + screenBuffer[0].length);
        System.out.println("h: " + screenBuffer.length);
    }

    public static void insertCentralBox() {
        //h6 18 w 2 42
        for (int i = 0; i < 17; i++){
            for (int j = 0; j < 42; j++){
                screenBuffer[6 + i][2 + j] = 'B';
            }

        }
    }



    public static void insertCentralPrompt() {
        //h21 25 w 2 42
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 42; j++){
                screenBuffer[24 + i][2 + j] = 'P';
            }
        }
    }

    public static void insertCentralPromptPoints(int itemIndex){
        switch(itemIndex){
            case 1 -> {
                screenBuffer[25][4] = 'p';
                screenBuffer[25][5] = '1';
            }
            case 2 -> {
                screenBuffer[26][4] = 'p';
                screenBuffer[26][5] = '2';
            }
            default -> throw new IllegalStateException("Unexpected value: " + itemIndex);
        }
    }

    public static void insertVersionIndicator(){
        screenBuffer[27][53] = 'v';
    }

    public static void insertLogo() {
        //h 0 3 w 2 6

        screenBuffer[1][2] = ' ';
        screenBuffer[1][3] = ' ';
        screenBuffer[1][4] = 'm';
        screenBuffer[1][5] = 'm';
        screenBuffer[1][6] = 'm';
        screenBuffer[2][2] = 'n';
        screenBuffer[2][3] = 'n';
        screenBuffer[2][4] = 'n';
        screenBuffer[2][5] = 'm';
        screenBuffer[2][6] = 'm';
        screenBuffer[3][2] = 'n';
        screenBuffer[3][3] = 'n';
        screenBuffer[3][4] = 'n';
        screenBuffer[3][5] = 'm';
        screenBuffer[3][6] = 'm';
        screenBuffer[4][2] = 'n';
        screenBuffer[4][3] = 'n';
        screenBuffer[4][4] = 'n';
        screenBuffer[4][5] = ' ';
        screenBuffer[4][6] = ' ';
    }

    public static void insertAppName() {
        //h 0 3 w 2 6
            screenBuffer[1 ][8] = 'A';

    }

    public static void insertUserName() {
        //h 0 3 w 2 6
        screenBuffer[1 ][47] = 'U';

    }

    public static void insertCompanyName() {
        //h 0 3 w 2 6
        screenBuffer[3 ][8] = 'C';

    }

    public static void insertSideBox() {
        //h4 24 w 47 57
        for (int i = 0; i < 21; i++){
            for (int j = 0; j < 15; j++){
                screenBuffer[4 + i][47 + j] = 'S';
            }
        }
    }

    public static void insertOptionsAnchors(){
        for (int i = 0; i < 17; i++){
            screenBuffer[4 + i][48 ] = 's';
            screenBuffer[4 + i][48 + 1] = (char) ('a' + i);
        }
    }


    public static void insertItemSolo (){
        int startingRow = 13;
        char startingLocationA = 'a';
        char startingLocationB = 'e';

        screenBuffer[startingRow - 1][4] = 'i';
        screenBuffer[startingRow - 1][5] = '1';

        for (int i = 0; i < 4; i++){
            screenBuffer[startingRow + i][4 ] = 'i';
            screenBuffer[startingRow + i][5 ] = (char) (startingLocationA + i);
        }

        for (int i = 0; i < 4; i++){
            screenBuffer[startingRow + i][24 ] = 'i';
            screenBuffer[startingRow + i][25 ] = (char) (startingLocationB + i);
        }
    }

    public static void insertItemListByThree(int startingRow, int itemIndex){
        char startingLocationA ;
        char startingLocationB ;
        char resultIndex;
        switch(itemIndex){
            case 1 -> {
                startingLocationA = 'a';
                startingLocationB = 'e';
                resultIndex = '1';
            }
            case 2 -> {
                startingLocationA = 'i';
                startingLocationB = 'm';
                resultIndex = '2';
            }
            case 3 -> {
                startingLocationA = 'q';
                startingLocationB = 'u';
                resultIndex = '3';
            }
            default -> throw new IllegalStateException("Unexpected value: " + itemIndex);
        }

        screenBuffer[startingRow - 1][4] = 'i';
        screenBuffer[startingRow - 1][5] = resultIndex;

        for (int i = 0; i < 4; i++){
            screenBuffer[startingRow + i][4 ] = 'i';
            screenBuffer[startingRow + i][5 ] = (char) (startingLocationA + i);
        }

        for (int i = 0; i < 4; i++){
            screenBuffer[startingRow + i][24 ] = 'i';
            screenBuffer[startingRow + i][25 ] = (char) (startingLocationB + i);
        }
    }

    public static void insertLeadStringRepository(Lead lead, int resultIndex, int listIndex){
        int startingRepository = 0;
        switch (listIndex){
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(lead.getId(), startingRepository++);
        insertStringIntoRepository(lead.getName(), startingRepository++);
        insertStringIntoRepository(lead.getPhoneNumber(), startingRepository++);
        insertStringIntoRepository(lead.getEmail(), startingRepository++);
        insertStringIntoRepository(lead.getCompanyName(), startingRepository++);
    }

    public static void insertOpportunityStringRepository(Opportunity opportunity, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex){
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(opportunity.getId(), startingRepository++);
        insertStringIntoRepository(opportunity.getDecisionMaker().getName(), startingRepository++);
        insertStringIntoRepository(opportunity.getProduct().toString(), startingRepository++);
        insertStringIntoRepository("Quantity: " + opportunity.getQuantity(), startingRepository++);
        insertStringIntoRepository(opportunity.getStatus().toString(), startingRepository++);
    }

    public static void insertContactStringRepository(Contact contact, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex){
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(contact.getId(), startingRepository++);
        insertStringIntoRepository(contact.getName(), startingRepository++);
        insertStringIntoRepository(contact.getPhoneNum(), startingRepository++);
        insertStringIntoRepository(contact.getEmail(), startingRepository++);
        insertStringIntoRepository(contact.getCompanyName(), startingRepository++);
    }

    public static void insertAccountStringRepository(Account account, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex){
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(account.getId(), startingRepository++);
        insertStringIntoRepository(account.getCompanyName(), startingRepository++);
        insertStringIntoRepository(account.getIndustry().toString(), startingRepository++);
        insertStringIntoRepository("Employee count: " + account.getEmployeeCount(), startingRepository++);
        insertStringIntoRepository(account.getCity(), startingRepository++);
        insertStringIntoRepository(account.getCountry(), startingRepository++);
    }

    public static void setUpLayout() {
        resetScreenBuffer();
        insertCentralBox();
        insertUserName();
        insertCentralPrompt();
        insertLogo();
        insertAppName();
        insertCompanyName();
        insertSideBox();
        insertOptionsAnchors();
        insertVersionIndicator();
    }

    public static void resetPromptMessages() {
        promptLineOne = "";
        promptLineTwo = "";
    }

    public static void resetPromptOne(){
        promptLineOne ="";
    }

    public static String getAppName() {
        return appName;
    }

    public static void setAppName(String appName) {
        Buffer.appName = appName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Buffer.companyName = companyName;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Buffer.userName = userName;
    }

    public static String getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(String currentLanguage) {
        Buffer.currentLanguage = currentLanguage;
    }

    public static String getPromptLineOne() {
        return promptLineOne;
    }

    public static void setPromptLineOne(String promptLineOne) {
        Buffer.promptLineOne = promptLineOne;
    }

    public static String getPromptLineTwo() {
        return promptLineTwo;
    }

    public static void setPromptLineTwo(String promptLineTwo) {
        Buffer.promptLineTwo = promptLineTwo;
    }

    public static String getResultItem() {
        return resultItem;
    }

    public static void setResultItem(String resultItem) {
        Buffer.resultItem = resultItem;
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static void setAppVersion(String appVersion) {
        Buffer.appVersion = appVersion;
    }


}
