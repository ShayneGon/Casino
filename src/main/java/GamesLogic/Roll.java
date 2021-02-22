package GamesLogic;
import java.util.Random;
public class Roll {
    private static Random randInt = new Random();
    private int colour;
    private int num;
    
    private int colour(){
        colour = randInt.nextInt(2);
        return colour;
    }
    private int number(){
        num = randInt.nextInt(36);
        return num;
    }

    protected Roll() {
        this.colour = colour();
        this.num = number();
    }

    protected int getColour() {
        return colour;
    }

    protected int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Roll{" + "colour=" + colour + ", num=" + num + '}';
    }
    
    
}
