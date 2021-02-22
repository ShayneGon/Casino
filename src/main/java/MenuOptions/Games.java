package MenuOptions;
import GamesLogic.Roulette;
import GamesLogic.BlackJack;
import GamesLogic.SlotMachine;
import java.util.Scanner;

public class Games{
    private static Scanner input = new Scanner(System.in);
    public static void gameOptions(){
        try{
            boolean repeat = true;
            while(repeat){
                long casinoPoints = 0;
                MainMenu.loginAccount.setCasinoPoints(casinoPoints+MainMenu.loginAccount.getCasinoPoints());
                int stake = 0;
                System.out.println("If you lose your stake goes to the Casino and you get Casino Points, the larger the stake - the more points you gain");
                System.out.println("What game would you like to play?");
                System.out.println("1 - Blackjack");
                System.out.println("2 - Slot Machines");
                System.out.println("3 - Roulette");
                System.out.println("0 - Enter to go back to account options");
                int gameChoice = input.nextInt();
                input.nextLine();
                
                do{
                    System.out.println("How much Bling would you like to stake? Enter 0 to quit");
                    stake = input.nextInt();
                    input.nextLine();
                }while (isWalletEmpty(stake));
                int streak = 0;
                while (stake != 0){
                    int multiplier = 0;
                    switch (gameChoice){
                        case 1:
                            //BlackJack;
                            if (streak == 0){
                                System.out.println("Welcome to Blackjack. This is the way it works:");
                                System.out.println("You pick cards, the aim is for the total value of all the cards to be as close to 21 as possible");
                                System.out.println("If you are closer to 21 than the computer, you win and double your stake, else you lose but get casino points. If you and the computer are the same distance away from 21 than you draw, your stake is preserved");
                            }else System.out.println("Lets go again");
                            multiplier = BlackJack.blackJack();
                            break;
                        case 2:
                            //Slots;
                            if (streak == 0){
                                System.out.println("Welcome to the slot machine. This is how it works:");
                                System.out.println("You have a chance if increasing your stake by either 10 times or 100 times if you get the jackpot");
                            }else System.out.println("Lets go again");
                            multiplier = SlotMachine.slotMachine();
                            break;
                        case 3:
                            //Roulette;
                            if (streak == 0){
                                System.out.println("Welcome to Roulette. The way it works:");
                                System.out.println("The roulette can land on a number between 0-36 inclusive, it can be either red or black");
                                
                                System.out.println("The Bling you stake will be doubled if your chosen number and the rolled number is even or odd, if they are both high or low numbers and if they are of the same colour");
                                System.out.println("The Bling you stake will be quadrupiled if you choose the same number as the rolled one");
                                System.out.println("If everything matches your Bling will be octupled");
                            }else System.out.println("Lets go again");
                            multiplier = Roulette.mainGame();
                            break;
                        case 0:
                            repeat = false;
                        default:
                            System.out.println("Enter valid option");
                    }streak++;
                    if (multiplier == 0){
                        casinoPoints += streak*stake;
                        System.out.println("Oh no you lost, don't worry you earned Casino Points, your current Casino Points for this game are "+casinoPoints);
                    }else{
                        stake *= multiplier;
                        MainMenu.loginAccount.setCasinoBling(stake+MainMenu.loginAccount.getCasinoBling());
                        System.out.println("You won "+stake+" Bling, you now have "+MainMenu.loginAccount.getCasinoBling()+" Bling in your casino wallet");
                    }
                    System.out.println("Your current streak is: "+streak);
                    System.out.println("When you stop playing a game the points you accumalated will be timesed by the streak");
                    int bling = 0;
                    do{
                        System.out.println("Enter your new stake - enter 0 to stop playing this game");
                        stake = input.nextInt();
                        input.nextLine();
                    }while(isWalletEmpty(stake));
                }
            }
        }catch(Exception e){
            System.out.println("An error has occured - please enter a valid input");
            System.out.println("Error in GameOptions: "+e);
            input.nextLine();
        }
    }
    public static boolean isWalletEmpty(int stake){ // deducts funs from the wallet if it isn't empty
        if (MainMenu.loginAccount.getCasinoBling()-stake < 0) {
            System.out.println("You don't have enough Bling to make that large of a stake, please make a smaller stake, else go back to login options and buy more Bling");
            return true;
        }else{
            System.out.println("Bet accepted");
            MainMenu.loginAccount.setCasinoBling(MainMenu.loginAccount.getCasinoBling()-stake);
            System.out.println("You have "+MainMenu.loginAccount.getCasinoBling());
            return false;
        }
    }
}
