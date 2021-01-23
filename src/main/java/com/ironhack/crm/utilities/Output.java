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
                    case 'S' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case 'a' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'b' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'c' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'd' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'e' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'f' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'g' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'h' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'i' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'j' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'k' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'l' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'm' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'n' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'o' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case 'p' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                        }
                    }
                    case 'B' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case '0' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '1' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '2' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '3' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '4' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '5' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '6' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '7' -> {
                                System.out.print(MAGENTA_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                        }
                    }
                    case 'P' -> {
                        switch (Buffer.screenBuffer[i][j + 1]){
                            case '0' -> {
                                System.out.print(GREEN_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '1' -> {
                                System.out.print(GREEN_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '2' -> {
                                System.out.print(GREEN_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                            case '3' -> {
                                System.out.print(GREEN_BCK + fillWithSpaces(80) + DEFAULT);
                                j += 39;
                            }
                        }
                    }
                    case 'L' -> {
                        System.out.print(BLUE_BCK + BLOCK + DEFAULT);
                    }
                    case 'A' -> {
                        System.out.print(CYAN_BCK + fillWithSpaces(20) + DEFAULT);
                        j += 9;
                    }
                    case 'C' -> {
                        System.out.print(RED_BCK + fillWithSpaces(20) + DEFAULT);
                        j += 9;
                    }

                    case 'U' -> {
                        System.out.print(WHITE_BCK + fillWithSpaces(20) + DEFAULT);
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
}
