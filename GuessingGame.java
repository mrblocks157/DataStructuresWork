import java.util.Scanner;
public class GuessingGame {
    int high;
    int low;
    int guesses;

    public GuessingGame(){
        this.high = 100;
        this.low = 0;
        this.guesses = 1;
    }

    public void guess(boolean higher, int guess){
        if(higher){
            low = guess+1;
        }
        else{
            high = guess-1;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GuessingGame game = new GuessingGame();
        System.out.println("Pick a value from 1-100 and I'll guess the number!");
        int guess = 50;
        System.out.println("My first guess is " + guess);
        while(true){
            System.out.println("Higher or Lower or Correct? (H/L/C)");
            String HL = scanner.nextLine();
            if(HL.equals("H")){
                game.guess(true, guess);
            }
            else if(HL.equals("L")){
                game.guess(false, guess);
            }
            else if(HL.equals("C")){
                break;
            }
            else{
                continue;
            }
            guess = (game.high+game.low)/2;
            System.out.println("My next guess is " + guess);
            game.guesses++;
        }
        System.out.println("Nice! The number was " + guess + " and it took " + game.guesses + " tries!");
    }
}