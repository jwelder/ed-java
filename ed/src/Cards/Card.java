package Cards;

/**
 *
 * @author jelder
 */
public class Card {
    
    private String suit;
    private String rank;
    private int value;
    private boolean faceUp = false;
    
    public Card(String suit, String rank, int value, boolean faceUp){
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.faceUp = faceUp;
    }

    public void printDetail() {
        System.out.printf("Suit: %s \t Rank: %s \t Value: %d", this.suit, this.rank, this.value);
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    
    
}
