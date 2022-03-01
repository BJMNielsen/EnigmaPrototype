public class EnigmaPrototype2 {

    char[] alphabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};

    public int encryption(char charInput) {
        for (int i = 0; i < alphabet.length; i++) {
            int indexOfChar = 0;
            if (charInput == alphabet[i]) {
                indexOfChar = i;
                return indexOfChar;
            }
        } return -1;
    }
    public char decryption(int index) {
        char charAtIndex = alphabet[index];
        return charAtIndex;
    }

    public static void main(String[] args) {
        System.out.println(new EnigmaPrototype2().encryption('G'));
        System.out.println(new EnigmaPrototype2().decryption(7));
    }
}