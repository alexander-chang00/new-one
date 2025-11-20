package cards;

import java.util.Random;

public class Deck {

    private Card[] cards;
    private int top;

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

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.length - 1; i > top; i--) {
            int j = top + rand.nextInt(i - top + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public void cut(int index) {
        if (index < 0 || index >= 52 || top != 0) {
            return;
        }

        Card[] newDeck = new Card[52];
        int pos = 0;

        for (int i = index; i < cards.length; i++) {
            newDeck[pos++] = cards[i];
        }
        for (int i = 0; i < index; i++) {
            newDeck[pos++] = cards[i];
        }

        cards = newDeck;
    }

    public Card draw() {
        if (top >= cards.length) {
            return null;
        }
        return cards[top++];
    }

    public void print(int count) {
        int limit = Math.min(count, cards.length - top);

        for (int i = 0; i < limit; i++) {
            System.out.print(cards[top + i] + " ");
        }
        System.out.println();
    }
}
