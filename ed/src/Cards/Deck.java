package Cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Simple class Deck to play card games with.
 * 
 * @author James Elder
 * @email james.wesley.elder@gmail.com
 * 
 */
public class Deck {
    
    private ArrayList<Card> cards;
    private boolean playCardUp = false;
    private String[] suits = {"Heart", "Diamond", "Spade", "Club"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Kight", "Queen", "King"};
    private int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
       
    public Deck(boolean playCard){
        this.initialize();
        this.playCardUp = playCard;
    }
    
    private void initialize(){
        this.cards = new ArrayList();
        for (String suit: this.suits){
            for(String rank: this.ranks){
                
                this.cards.add(new Card(suit, rank, 10, this.playCardUp));
                
            }
        }
        this.shuffle();
    }
    
    public void shuffle(){
        Collections.shuffle(this.cards);
    }
    
    public Card removeCard(){
        
        return (Card) this.cards.remove(0);
    }
    
    public Card dealCard(){
        
        return (Card) this.cards.remove(0);
    }
    
    public void addCard(Card card){
        this.cards.add(card);
    }
    
    public void show(){
        for(Card card: this.cards){
            card.printDetail();
            System.out.println();
        }
    }
    
    
}
