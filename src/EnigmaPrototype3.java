import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class EnigmaPrototype3 {

    Scanner input = new Scanner(System.in);
    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";

    public String userInput() {
        System.out.println("Pls input the word you would like to encrypt");
        String userInput = input.nextLine().toUpperCase(Locale.ROOT);
        return userInput;
    }

    public int charToNumber(char bogstav) {
        int indexOfChar = alfabet.indexOf(bogstav);
        return indexOfChar;
    }

    public int[] caesarEncryption(String userInput) {
        int[] array1 = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            char charAtIndex = userInput.charAt(i);
            int indexOfChar = charToNumber(charAtIndex);
            array1[i] = indexOfChar;
        }
        return array1;
    }

    public char NumberToChar(int number) {
        char charAtIndex = alfabet.charAt(number);
        return charAtIndex;
    }

    public static void main(String[] args) {
        EnigmaPrototype3 prototype = new EnigmaPrototype3();
        String input = prototype.userInput();
        int[] result = prototype.caesarEncryption(input);
        System.out.println(Arrays.toString(result));
    }
}
