package cards;

import java.util.Random;

import javax.smartcardio.Card;

import piglatin.string;

public class Deck {
//fields
    private Card[] cards;
     private int top;
//constructor
    public Deck() {
        cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                cards[index] = new Card(suit, value);
                index++;
            }
        }

        top = 0;
    }
//methods
    public void shuffle() {
        Random rand = new Random();

        // Fisher–Yates shuffle from top to end
        for (int i = cards.length - 1; i > top; i--) {
            int j = top + rand.nextInt(i - top + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
       public void cut(int index) {
        if (index < 0 || index > 51 || top != 0) {
            return;
        }

        Card[] newDeck = new Card[52];
        int pos = 0;
        for (int i = index; i < cards.length; i++) {
            newDeck[pos] = cards[i];
            pos++;
        }
        for (int i = 0; i < index; i++) {
            newDeck[pos] = cards[i];
            pos++;
        }

        cards = newDeck;
    }
     public Card draw() {
        if (top >= cards.length) {
            return null;
        }
        Card c = cards[top];
        top++;
        return c;
    }
      public void print(int count) {
        if (count < 0) {
            return;
        }

        int limit = Math.min(count, cards.length - top);

        for (int i = 0; i < limit; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[top + i]);
        }
        System.out.println();
    }
}