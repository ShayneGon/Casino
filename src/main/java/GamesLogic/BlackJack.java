package GamesLogic;
import java.util.Scanner;
import java.util.ArrayList;
        
public class BlackJack extends Deck{
    private static Scanner input = new Scanner(System.in);
    private static int cardsNum = 0;
    private static int compCardsNum = 0;
    
    public static int blackJack(){
        setUpDeck();
        boolean compRepeat = true;
        boolean repeat = true;
        do{
            if (repeat) {
                repeat = playerPick();
            }
            if (compRepeat) {
               compRepeat = compPick(); 
            }
        }while (repeat == true || compRepeat == true);
        System.out.println("Game Over");
        if (cardsNum > 21) {
            System.out.println("You went over 21, so you lose");
            return 0;
        }else if (compCardsNum > 21){
            System.out.println("Computer went over 21, so you win");
        }else if (cardsNum == 21) {
            if (compCardsNum == 21) {
                System.out.println("Both you and the computer got 21, you will not lose your bet");
                return 1;
            }
        }else if (cardsNum <= compCardsNum) {
            if (cardsNum == compCardsNum) {
                System.out.println("The computer and you were the same distance away from 21, draw");
                return 1;
            }else{
                System.out.println("The computer was closer to 21 than you, you lose");
                return 0;
            }
        }System.out.println("You win");
        return 2;
    }
    
    private static boolean playerPick(){
        try{
            if (cardsNum < 21) {
                System.out.println("Your currently on "+cardsNum);
                System.out.println("Do you want to pick another card? y or n");
                String userOption = input.nextLine();
                if (userOption.equalsIgnoreCase("y")){
                    int card = Deck.pickUpCard();
                    if (card == 1){
                        System.out.println("You picked an Ace, it can be worth either 1 or 14, what value  do you want it to be?");
                        System.out.println("Your hand's value is currently "+cardsNum);
                        int userChoice = input.nextInt();
                        input.nextLine();
                        while (userChoice != 1 || userChoice != 14){
                            System.out.println("Enter a valid option - 1 or 14");
                            userChoice = input.nextInt();
                            input.nextLine();
                        }card = userChoice;
                    }
                    cardsNum += card;
                    System.out.println("You picked an "+Deck.cardName(card)+", the value of your hand is "+cardsNum);
                    return true;
                }
            }return false;
        }catch(Exception e){
            System.out.println("Invalid Input! Please enter a valid input");
            System.out.println("Error: "+e);
            input.nextLine();
            return false;
        }
    }
    private static boolean compPick(){
        if (compCardsNum < 21){
            int prob = 21-compCardsNum;
            if ((countCards(prob) || cardsNum > compCardsNum) && cardsNum <= 21){
                int card = Deck.pickUpCard();
                compCardsNum += card;
                System.out.println("The comp picked an "+Deck.cardName(card)+", the value of the computer's hand is "+compCardsNum);
                return true;
            }else System.out.println("The computer doesn't want to pick a card");
        }return false;
    }
    private static boolean countCards(int prob){
        int index = Deck.getCardIndex(prob); // This cause the comp to act logically, for greater risk taking increase prob
        int size = getDeckSize()+4;
        size /= 2;
        if (index >= size){
            return true;
        }else return false;
    }
}
