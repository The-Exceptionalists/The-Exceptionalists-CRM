package com.ironhack.crm.utilities;

public class Output {

    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String BLOCK = "  ";
    private static final String MAGENTA_BCK = (char) 27 + "[45m";
    private static final String YELLOW_BCK = (char) 27 + "[43m";

    public static void printScreen() {
        for (int i = 0; i < Buffer.screenBuffer.length; ++i) {
            for (int j = 0; j < Buffer.screenBuffer[i].length; ++j) {
                switch (Buffer.screenBuffer[i][j]) {
                    case ' ' -> System.out.print(BLOCK);
                    case 'S' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case '0' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '1' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '2' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '3' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '4' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '5' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '6' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '7' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '8' -> {
                                System.out.print(YELLOW_BCK + fillWithSpaces(20) + DEFAULT);
                                j += 9;
                            }
                            case '9' -> {
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
