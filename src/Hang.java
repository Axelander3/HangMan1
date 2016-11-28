import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by maal15 on 2016-10-26.
 *
 * TODO
 * Göra så att när man har skivit in sista bokstaven att man vinner.
 * Läsa in ord från en text fil
 *
 */
public class Hang {

    public static void main(String[] arg) {

        Scanner s = new Scanner(System.in);

        String[] guessedWords = new String[12];

        int guessedWordss = 0;

        String[] words = new String[5];

        words[0] = "hello";
        words[1] = "test";
        words[2] = "hej";
        words[3] = "programmering";


        char[] guessedLetters = new char[26];

        int guessedLetterss = 0;

        guessedLetters[1] = 'a';

        boolean running = true;

        int tries = 0;

        Random r = new Random();
        int num = r.nextInt(words.length);
        String word = words[num];


        char[] found = new char[word.length()];

        for(int i = 0; i<found.length;i++) {
            found[i] = '_';
        }


        while (running) {

            if ((tries >= 12)) {
                running = false;
                System.out.println("Du förlora.");
            }

           /* if (found.length == word.length()) {
                System.out.println("YOU WIN!");
                running = false;
            }*/

            System.out.println("Guess what word it is! " + String.valueOf(found) + " the word is " + word.length() + " carracters long!");
            String guess = s.next();

            if (!(guess.length() == 1)) { // kollar om det är ett ord eller en bokstav.
                if (guess.equalsIgnoreCase(word)) { // kollar om gissningen är samma som ordet!
                    System.out.println("YOU WIN!"); // du vinner
                    running = false;
                } else {
                    tries++;
                    guessedWords[guessedWordss] = guess;
                    guessedWordss++;
                    System.out.println("Du gissade på fel ord. Du har " + (12 - tries) + " försök kvar!");
                }
            } else { // bokstav
                if (word.contains(guess)) { // kollar om bokstaven finns i ordet
                    guessedWords[guessedLetterss] = guess;
                    guessedLetterss++;
                    System.out.println("Bokstaven har lagts till i ordet!");

                    int pos = word.indexOf(guess);

                    found[pos] = guess.charAt(0);


                } else {
                    tries++;
                    guessedWords[guessedLetterss] = guess;
                    guessedLetterss++;
                    System.out.println("Bokstaven finns inte med i ordet. Du har " + (12 - tries) + " försök kvar!");
                }
            }
        }

    }

}
