package cards;


public class Hand {
    private int max=13;
    private static Card[] hand;
    int topNum=0;
//constructer
    public Hand(int max){
        this.max=max;
        topNum=0;
    }
//methods
    public void add(Card c){
        if(hand.length<max){
            hand[topNum]=c;
            topNum++;
        }
        else{
            System.out.println("no can do bud, your hand is full");
        }
    }
    public int length(){
        return topNum;
    }
     public Card get(int index) {
        if (index < 0 || index >= topNum) {
            return null;
        }
        return hand[index];
    }
      public String toString() {
        String result = "";
        for (int i = 0; i < topNum; i++) {
            if (i > 0) {
                result += " ";
            }
            result += hand[i].toString();
        }
        return result;
    }
      public Card remove(int index) {
        if (index < 0 || index >= topNum) {
            return null;
        }

        Card removed = hand[index];

        // shift everything after index one spot to the left
        for (int i = index; i < topNum - 1; i++) {
            hand[i] = hand[i + 1];
        }

        hand[topNum - 1] = null;   // optional, just clears the last slot
        topNum--;

        return removed;
    }
}