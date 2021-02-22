package GamesLogic;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static ArrayList<Integer> deck = new ArrayList<>();
    protected static void setUpDeck(){
        deck.clear();
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
    }

    public static int getDeckSize() {
        return deck.size();
    }
    
    
    protected static int pickUpCard(){
        Random randInt = new Random();
        int cardIndex = randInt.nextInt(deck.size()-2)+2;
        int card = deck.get(cardIndex);
        deck.remove(cardIndex);
        return card;
    }
    protected static String cardName(int card){
        if (card <= 10){
            if (card == 1 || card == 14){;
                return "Ace";
            }else return Integer.toString(card);
        }if (card == 11){
            return "Jack";
        }if (card == 12){
            return "Queen";
        }else return "King";
    }
    protected static int getCardIndex(int card){
        if (card >= 14){
            return 52;
        }
        int n = 0;
        for (int i = deck.size()-1; i > deck.size()-5; i--) {
            if (deck.get(i) == 14){
                n++;
            }
        }
        if (card > 7) {
            for (int i = 8; i < 15; i++) {
                for (int j = 0; j < deck.size(); j++) {
                    if (card == deck.get(j)){
                        for (int k = j+5; k > j; k--) {
                            if (card == deck.get(k)){
                                return k+n+1;
                            }
                        }
                    }
                }
            } 
        }else{
            for (int i = 0; i < card-1; i++) {
                for (int j = 0; j < deck.size(); j++) {
                    if (card-i == deck.get(j)){
                        for (int k = j+5; k > j; k--) {
                            if (card == deck.get(k)) {
                                return k+n+1;
                            }
                        }
                    }
                }
            } 
       }return n;      
    }
}
