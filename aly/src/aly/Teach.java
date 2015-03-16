/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aly;

import java.util.Scanner;

/**
 *
 * @author jelder
 */
public class Teach {
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println("Welcome to the NHL play by play event scraper."
                + " The system will get events for the specified game for the specified "
                + "event type");
        
        
        Scanner in = new Scanner(System.in);
        String response;
        boolean continuePlay = true;
        
        while(continuePlay){
            System.out.println("Give me a number");
            response = in.nextLine();
            
            if(response.equalsIgnoreCase("exit")){
                continuePlay = false;
                System.out.println("bye");
            }else{
                
                int gameNumber = 0;
                
                 try {
                     gameNumber = Integer.parseInt(response);
                 }catch(Exception e){
                     System.out.println("Invalid number.");
                 }     
                        
                if(gameNumber < 20001 || gameNumber < 20001){
                    
                }else{
                    
                    
                    
                    
                    
                }
                
            }
            
            
            
        }
        
        
    }
    

    

    
}



