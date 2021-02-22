package GamesLogic;
import java.util.Random;

public class SlotMachine {
    public static int slotMachine(){
        Random randInt = new Random();
        int num = randInt.nextInt(1000000);
        if (num == 69420){
            System.out.println("\\u001B[31m"+"JACKPOT!!!");
            return 100;
           
        }else if (num == 420 || num == 69 || num == 261003 || num == 181278 || num == 200489 || num == 40468 || num == 4170 || num == 7){
            System.out.println("You won");
            return 10;
        }else return 0;
    }
    
}
