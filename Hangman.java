import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Hangman {
    char[] word;
    char[] hidden;
    ArrayList<Character> used;
    int triesLeft;
    public Hangman(String word){
        this.word = word.toCharArray();
        this.hidden = new char[word.length()];
        this.used = new ArrayList<Character>();
        Arrays.fill(hidden, '_');
        triesLeft = 6;
    }

    public void replace(char C){
        for (int i = 0; i<word.length; i++){
            if(word[i] == C){
                hidden[i] = C;
            }
        }
    }

    public boolean win(){
        for(char c : hidden){
            if((c == '_')){
                return false;
            }
        }
        return true;
    }

    public boolean cCheck(char C){
        used.add(C);
        for(char c : word){
            if(c == C){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java", "hangman", "keyboard", "program", "random", "computer"};
        Random rand = new Random();
        String secretWord = words[rand.nextInt(words.length)];

        Hangman word = new Hangman(secretWord);
        System.out.println("I've thought of a word...");
        while(true){
            if(word.triesLeft == 0){
                System.out.println("You ran out of tries!");
                break;
            }
            for(char w : word.hidden){
                System.out.print(w);
            }
            System.out.println();
            System.out.println("What's your guess?");
            String c = scanner.nextLine();
            if(word.used.contains(c)){
                System.out.println("You've used that guess." + " You have " + word.triesLeft + " tries left!");
                continue;
            }
            if(word.cCheck(c.charAt(0))){
                System.out.println("The word contains " + c + "!" + " You have " + word.triesLeft + " tries left!");
                word.replace(c.charAt(0));
            }
            else{
                word.triesLeft--;
                System.out.println("The word doesn't contains " + c + "." + " You have " + word.triesLeft + " tries left!");
            }
            if(word.win()){
                System.out.println("Congratulations! The word was " + secretWord);
                break;
            }
        }
    }
}
