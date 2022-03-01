import java.util.Locale;
import java.util.Scanner;

public class EnigmaPrototype {

    //Scanner input = new Scanner(System.in);
    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";

    public int caesarEncryption(char bogstav) {
        int indexOfChar = alfabet.indexOf(bogstav);
        return indexOfChar;
    }

    public char caesarDecrypting(int number) {
        char charAtIndex = alfabet.charAt(number);
        return charAtIndex;
    }

    public static void main(String[] args) {
        System.out.println(new EnigmaPrototype().caesarEncryption('g'));
        System.out.println(new EnigmaPrototype().caesarDecrypting(7));
    }
}
