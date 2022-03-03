import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class EnigmaPrototype3 {

    public static void main(String[] args) {

        EnigmaPrototype3 prototype = new EnigmaPrototype3();
        while (prototype.isRunning == true) {
            String answer = prototype.encryptOrDecrypt();
            String sentenceInput = prototype.userSentence();
            int shiftValue = prototype.askShiftValue();

            if (answer.equalsIgnoreCase("ENCRYPT")) {
                String wordEncrypted = prototype.encryption(sentenceInput, shiftValue);
                System.out.println("Your word has been encrypted. " + sentenceInput + " has been encrypted into: " + wordEncrypted);

            } else if (answer.equalsIgnoreCase("DECRYPT")) {
                String decryptedWord = prototype.decryption(sentenceInput, shiftValue);
                System.out.println("Your word has been encrypted. " + sentenceInput + " has been decrypted into " + decryptedWord);

            } else
                System.out.println("Sorry that input isn't valid");

            prototype.isRunning = prototype.continueProgram();
        }
    }

    boolean isRunning = true;
    Scanner input = new Scanner(System.in);
    String alfabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";


    public String encryptOrDecrypt() {
        System.out.println("Hello. Welcome to the caesar encryption machine.");
        System.out.println("Would you like to encrypt a message or decrypt af message?");
        String userInput = input.nextLine().toUpperCase(Locale.ROOT);
        return userInput;
    }

    public int askShiftValue() {
        System.out.println("Hello, please enter a positive shift value"); // kan laves senere så den tager både negativ og positiv value
        int userInput = input.nextInt();
        return userInput;
    }

    public String userSentence() {
        System.out.println("Pls input the word you would like to encrypt");
        String userInput = input.nextLine().toUpperCase(Locale.ROOT);
        return userInput;
    }

    public int[] stringIntoNumbers(String userInput) {
        int[] arrayStoreUserInput = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            ;
            arrayStoreUserInput[i] = letterToNumber(userInput.charAt(i));
        }
        return arrayStoreUserInput;
    }

    public int[] shiftNumbers(int[] arrayOfNumbers, int shiftNumber) {
//        if (encryptOrDecrypt().equalsIgnoreCase("decrypt")) {
//            for (int i = 0; i < arrayOfNumbers.length; i++) {
//                arrayOfNumbers[i] = arrayOfNumbers[i] - shiftNumber;
//            }
//        } else if (encryptOrDecrypt().equalsIgnoreCase("encrypt")) {
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                arrayOfNumbers[i] = arrayOfNumbers[i] + shiftNumber;
            } return arrayOfNumbers;

        }
//    }

    public String makeStringFromShiftValues(int[] arrayOfShiftNumbers) {
        String encryptedMessage = "";
        char x;
        for (int i = 0; i < arrayOfShiftNumbers.length; i++) {
            x = numberToLetter(arrayOfShiftNumbers[i]);
            encryptedMessage += x;
        }
        return encryptedMessage;
    }

    public String encryption(String sentenceInput, int shiftValue) {
        int[] stringIntoNumbers = stringIntoNumbers(sentenceInput);
        int[] shiftedNumbers = shiftNumbers(stringIntoNumbers, shiftValue);
        String encryptedMessage = makeStringFromShiftValues(shiftedNumbers);
        return encryptedMessage;
    }

    public String decryption(String encryptedMessage, int shiftValue) {
        int[] encryptedStringIntoNumbers = stringIntoNumbers(encryptedMessage);
        int[] encryptedNumbersShifted = shiftNumbers(encryptedStringIntoNumbers, shiftValue);
        String decryptedMessage = makeStringFromShiftValues(encryptedNumbersShifted);
        return decryptedMessage;
    }

    public int letterToNumber(char bogstav) {
        int indexOfChar = alfabet.indexOf(bogstav);
        return indexOfChar;
    }

    public char numberToLetter(int number) {
        char charAtIndex = alfabet.charAt(number);
        return charAtIndex;
    }

    public boolean continueProgram() {
        System.out.println("Would you like to continue the program? Answer yes or no.");
        String userInput = input.nextLine();
        input.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {
            isRunning = true;
        } else if (userInput.equalsIgnoreCase("no")) {
            isRunning = false;
        }
        return isRunning;
    }
}