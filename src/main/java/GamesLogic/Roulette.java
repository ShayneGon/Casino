package GamesLogic;
import GamesLogic.Roll;
import java.util.Scanner;

public class Roulette {
    public static int mainGame() {
        int multiplier = 1;
        Scanner input = new Scanner(System.in);
        try{
        Roll currentRoll = new Roll();
        String color = (currentRoll.getColour() == 0)? "red":"black";
        System.out.println("The roulette landed on a "+color+" "+currentRoll.getNum());
        System.out.println(currentRoll.toString());
        System.out.println("Pick a number between 0-36");
        int num = input.nextInt();
        System.out.println("Is it going to be red[0] or black[1]?");
        int colour = input.nextInt();
        if (currentRoll.getColour() == colour && isHigh(currentRoll.getNum()) == isHigh(num) && isEven(currentRoll.getNum()) == isEven(num)) {
            multiplier *= 2;
            System.out.println("You were right on the colour, it's magnitude and whether it is even or not");
        }if (num == currentRoll.getNum()){
            multiplier *= 4;
            System.out.println("You were correct about the number");
        }if (multiplier == 1) {
            System.out.println("You lost");
            multiplier = 0;
        }else System.out.println("You won - Your Bling multiplier is: "+multiplier+" times");
        return multiplier;
        }catch(Exception e){
            System.out.println("Error: "+e+" You will be redirected to the menu, your stake will not be lossed");
            return 1;
        }
    }
    
    private static boolean isHigh(int num){
        if (num >= 19){
            return true;
        }else return false;
    }
    private static boolean isEven(int num){
        if (num % 2 == 0){
            return true;
        }else return false;
    }
}
