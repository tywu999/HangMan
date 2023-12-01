import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        String[] list = readString("inputThreeFour.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please a random number between 1 - 400");
        int input = scanner.nextInt();
        System.out.println("Johnny is arrested due to FALSE ALLEGATIONS, you have 8 chances to guess the word to save him!");
        String a = list[input+5];
        char[] before = new char[a.length()];
        char[] wordy = new char[before.length];
        for(int ii = 0; ii < wordy.length; ii++){
            char z = '_';
            wordy[ii] = z;
        }
        for(int i = 0; i < 9; i++){

            char[] after = Hang(a);
            char[] wordy2 = new char[wordy.length];
            System.arraycopy(wordy, 0, wordy2, 0, wordy.length);
            for(int ii = 0; ii < wordy.length; ii++){
                if(after[ii] != '_'){
                    wordy[ii] = after[ii];
                }
            }
            int k = i;
            for(int ii = 0; ii < wordy.length; ii++){
                if(wordy2[ii] != wordy[ii]){
                    System.out.println("What a GUESS, Johnny is Safer Now!");
                    i = i-1;
                    k = -1;
                    break;
                }

            }
            System.out.println(wordy);
            conditions(k);
            System.out.println("You have " + (7-i) + " guess left");
            int counter = 0;
            for(int ii = 0; ii < after.length; ii++){
                if(wordy[ii] == '_'){
                    counter++;
                }
            }
            if(counter == 0){
                System.out.println("YOU WON!" + "   Johnny is FREE!");
                break;
            }
            if(i == 7){
                System.out.println("GAME OVER, YOU ARE OUT OF GUESSES");
                break;
            }
        }
    }
    public static char[] Hang(String a){
        String word = a;
        char[] wordList = new char[word.length()];
        for(int i = 0; i < wordList.length; i++){
            char z = '_';
            wordList[i] = z;
        }
        for(int i = 1; i < 8; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input your character");
            char input = scanner.next().charAt(0);
            int k = 0;
            for(int ii = 0; ii < wordList.length; ii++){
                if(word.charAt(ii) == input){
                    wordList[ii] = input;

                }
            }
            return wordList;
        }
        return wordList;


    }



    private static String[] readString(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {

            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
    public static void conditions(int a){
        if(a >= 0 && a < 3){
            System.out.println("UH OH! The hanging rack for Johnny is being built!");
        }
        if(a >= 3 && a < 5){
            System.out.println("SHOOT, The noose for Johnny is being tied around his neck!");
        }
        if(a >= 5 && a < 7){
            System.out.println("They are LOWERING Johnny's platform, do SOMETHING");
        }
    }
}