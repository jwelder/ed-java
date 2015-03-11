/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

/**
 *
 * @author jelder
 */
public class Play {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Deck deck = new Deck(true);
        
        System.out.println("Game 1");
        deck.show();
        
        System.out.println("Game 2");
        deck.shuffle();      
        deck.show();
        
    }
    
}
