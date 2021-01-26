package com.ironhack.crm.utilities;

public class Output {

    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String BLOCK = "  ";
    private static final String MAGENTA_BCK = (char) 27 + "[45m";
    private static final String YELLOW_BCK = (char) 27 + "[43m";
    private static final String GREEN_BCK = (char) 27 + "[42m";
    private static final String RED_BCK = (char) 27 + "[41m";
    private static final String BLUE_BCK = (char) 27 + "[44m";
    private static final String CYAN_BCK = (char) 27 + "[46m";
    private static final String WHITE_BCK = (char) 27 + "[30;47m";

    public static void printScreen() {
        for (int i = 0; i < Buffer.screenBuffer.length; ++i) {
            for (int j = 0; j < Buffer.screenBuffer[i].length; ++j) {
                switch (Buffer.screenBuffer[i][j]) {
                    case ' ' -> System.out.print(BLOCK);
                    case 'i' -> {
                        switch(Buffer.screenBuffer[i][j + 1]){
                            case 'a' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(10), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'b' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(11), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'c' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(12), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'd' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(13), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'e' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(14), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'f' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(15), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'g' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(16), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'h' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(17), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'i' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(18), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'j' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(19), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'k' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(20), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'l' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(21), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'm' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(22), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'n' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(23), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'o' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(24), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'p' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(25), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'q' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(26), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'r' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(27), 30) + DEFAULT);
                                j += 14;
                            }
                            case 's' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(28), 30) + DEFAULT);
                                j += 14;
                            }
                            case 't' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(29), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'u' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(30), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'v' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(31), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'w' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(32), 30) + DEFAULT);
                                j += 14;
                            }
                            case 'x' -> {
                                System.out.print(MAGENTA_BCK + insertText(Buffer.getStringFromRepository(33), 30) + DEFAULT);
                                j += 14;
                            }

                        }
                    }
                    case 'p' -> {
                        switch(Buffer.screenBuffer[i][j + 1]){
                            case '1' -> {
                                System.out.print(GREEN_BCK + insertText(Buffer.getPromptLineOne(), 30) + DEFAULT);
                                j += 14;
                            }
                            case '2' -> {
                                System.out.print(GREEN_BCK + insertText(Buffer.getPromptLineTwo(), 30) + DEFAULT);
                                j += 14;
                            }
                        }
                    }
                    case 'S' -> {
                        System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                        j += 9;
                    }
                    case 'B' ->
                        System.out.print(MAGENTA_BCK + fillWithSpaces(2) + DEFAULT);

                    case 'P' -> System.out.print(GREEN_BCK + fillWithSpaces(2) + DEFAULT);
                    case 'L' -> System.out.print(BLUE_BCK + BLOCK + DEFAULT);
                    case 'A' -> {
                        System.out.print(CYAN_BCK + Output.insertText(Buffer.getAppName(), 20) + DEFAULT);
                        j += 9;
                    }
                    case 'C' -> {
                        System.out.print(RED_BCK + Output.insertText(Buffer.getCompanyName(), 20) + DEFAULT);
                        j += 9;
                    }

                    case 'U' -> {
                        System.out.print(WHITE_BCK + Output.insertText(Buffer.getUserName(), 20) + DEFAULT);
                        j += 9;
                    }
                }
            }
            System.out.println();
        }
    }

    public static String fillWithSpaces(int len) {
        StringBuilder r = new StringBuilder();
        if (len > 0) r.append(" ".repeat(len));
        return r.toString();
    }

    public static String insertText(String text, int len) {
        int strLen = text.length();
        text = strLen > len ? text.substring(0, len) : text;
        return text + Output.fillWithSpaces(len - strLen);
    }
}
