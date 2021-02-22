package GamesLogic;
import MenuOptions.Games;
import java.util.ArrayList;
import java.util.Scanner;
//Currently unavailable due to difficulties planning on giving cards suits

public class Poker extends Deck{
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Integer> hand = new ArrayList<>();
    private static ArrayList<Integer> compHand = new ArrayList<>();
    public static int playPoker(int stake){  
        int currentStake = stake/3;
        int newStake = currentStake;
        stake -= currentStake;
        System.out.println("Your buy in stake is "+currentStake+" Bling, your remaining stake is "+stake+" Bling");
        for (int i = 0; i < 2; i++) {
           hand.add(pickUpCard());
           compHand.add(pickUpCard());
        }System.out.println("Your hand: "+cardName(hand.get(0))+", "+cardName(hand.get(1)));
        System.out.println("Would you like to fold[0], check[1] or raise[2]");
        int userChoice = input.nextInt();
        input.nextLine();
        switch (userChoice){
            case 0:
                System.out.println("You have lost you stake");
                return 0;
            case 1: 
                System.out.println("You have staked: "+stake+ " Bling");
                currentStake += newStake;
                break;
            case 2:
                do {
                    do{
                        System.out.println("Enter your raised stake - if you want to check enter the original stake, if you want to fold enter an number less than the current stake");
                        newStake = input.nextInt();
                        input.nextLine();
                    }while (currentStake >= stake);
                }while (Games.isWalletEmpty(newStake));
                if (newStake < currentStake){
                    System.out.println("You have lost your stake");
                    return 0;
                }else{
                    System.out.println("You have raised your stake");
                    currentStake += stake;
                }
        } return 2;
    }
}
