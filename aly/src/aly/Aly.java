/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jelder
 */
public class Aly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * 
         */       
        boolean continuePlay = true;
        String response;
        int gameNumber;
        String eventType;
        int eventNumber;
        String nthShot;
        String shotData;
        int writeStatus;
        int readStatus;
        
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the NHL play by play event scraper."
                + " The system will get events for the specified game for the specified "
                + "event type");

        while (continuePlay) {

            System.out.println("Please enter a valid game number. ");

            response = in.nextLine();

            if (response.equalsIgnoreCase("exit")) {
                continuePlay = false;
            } else {

                try {
                    gameNumber = Integer.parseInt(response);
                } catch (Exception e) {
                    gameNumber = 0;
                }

                if (gameNumber > 21230 || gameNumber < 20001) {
                    System.out.println("Invalid game number. Please try again.");
                } else {

                    boolean validShot = false;
                    System.out.println("Game Number: " + gameNumber);

                    System.out.println("Please enter a valid event type: ");
                    eventType = in.nextLine();

                    while (!validShot) {

                        if (eventType.equalsIgnoreCase("exit")) {
                            continuePlay = false;
                            break;
                        } else if (!eventType.equalsIgnoreCase("SHOT")) {
                            System.out.println("Invalid event type.");
                            System.out.println("Please enter a valid event type: ");
                            eventType = in.nextLine();
                        } else {
                            validShot = true;
                        }
                    }

                    if (continuePlay) {

                        boolean validEventNumber = false;

                        while (!validEventNumber) {
                            System.out.println("Please enter the nth " + eventType + " you would like.");
                            response = in.nextLine();

                            try {
                                eventNumber = Integer.parseInt(response);
                            } catch (Exception e) {
                                eventNumber = 0;
                            }

                            if (response.equalsIgnoreCase("exit")) {
                                continuePlay = false;
                                break;
                            } else if (eventNumber < 1) {
                                System.out.println("Invalid event number.");

                            } else {
                                validEventNumber = true;
                            }
                        }

                    }

                    if (continuePlay) {

                        nthShot = getNthEventByType();
                        shotData = getShotDataFromEventHTML(nthShot);

                        try {
                            writeStatus = writeRecordToFile(gameNumber, eventType, shotData);
                        } catch (IOException e) {
                            System.out.println("Error writing to file.");
                            writeStatus = 0;
                        }

                        System.out.println("The write status is: " + writeStatus);

                        if (writeStatus > 0) {
                            try {
                                readStatus = printRecordsFromFile(gameNumber, eventType);
                                
                            } catch (IOException ex) {
                                readStatus = 0;
                                System.out.println("Error reading the file.");
                                
                            }

                            System.out.println("The read status is: " + readStatus);
                        } else {

                        }

                    }

                }

            }

        }

        System.out.println("Bye, have a nice day.");

    }

    private static String getNthEventByType() {
        return "<td class=\" + bborder\">CHI ONGOAL - #20 SAAD, Wrist, Off. Zone, 53ft.</td>";
    }

    private static String getShotDataFromEventHTML(String nthShot) {
        return "CHI ONGOAL, #20 SAAD, Wrist, Off. Zone, 53ft.";
    }

    private static int writeRecordToFile(int gameNumber, String eventType, String shotData) throws IOException {
        String fileName = gameNumber + "_" + eventType + ".csv";
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            out.println(shotData);
            out.close();
            return 1;
        } catch (IOException e) {
            return 0;
        }
    }

    private static int printRecordsFromFile(int gameNumber, String eventType) throws IOException {
        String fileName = gameNumber + "_" + eventType + ".csv";
        
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null){
            System.out.println(line);
            line = br.readLine();
        }
        
        return 1;
        
    }

}
