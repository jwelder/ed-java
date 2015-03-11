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
    
    private ArrayList cards;
    private boolean playCardUp = false;
    
    public void Deck(boolean playCard){
        this.cards = new ArrayList<Card>();
        this.playCardUp = playCard;
    }
    
    public void shuffle(){
        Collections.shuffle(this.cards);
    }
    
    public Card removeCard(){
        
        return new Card();
    }
    
    public Card dealCard(){
        
        return new Card();
    }
    
    public void addCard(Card card){
        this.cards.add(card);
    }
    
    
    
    
}
