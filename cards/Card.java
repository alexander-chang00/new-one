package cards;

public class Card {
//fields   
    private int value;
    private int suit;
    private static String[] suits={"♦","♣","♥","♠"};
    private static String[] values={"a", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
//constructor
    public Card(int suit, int value){
        this.value=value;
        this.suit=suit;
    }
//methods
    public int getValue(){
        return(value);
    }
    public String tooString(){
        return(suits[suit]+values[value]);
    }
}