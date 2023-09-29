public class MyCaesar {

    public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private int n;// shift steps (right shift)

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    public char encryptChar(char c) {
        if (new String(ALPHABET).indexOf(c) < 0 && new String(NUMBERS).indexOf(c) < 0) {
            return c;
        }
        int index, indexShift;
        if (Character.isDigit(c)) {
            index = c - NUMBERS[0];
            indexShift = (index + n) % NUMBERS.length < 0 ? (index + n) % NUMBERS.length + NUMBERS.length : (index + n) % NUMBERS.length;
        } else {
            index = c - ALPHABET[0];
            indexShift = (index + n) % ALPHABET.length < 0 ? (index + n) % ALPHABET.length + ALPHABET.length : (index + n) % ALPHABET.length;
        }
        return Character.isDigit(c) ? NUMBERS[indexShift] : ALPHABET[indexShift];
    }

    public String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(encryptChar(input.charAt(i)));
        }
        return result.toString();
    }

    public char decryptChar(char c) {
        if (new String(ALPHABET).indexOf(c) < 0 && new String(NUMBERS).indexOf(c) < 0) {
            return c;
        }
        int index, indexShift;
        if (Character.isDigit(c)) {
            index = c - NUMBERS[0];
            indexShift = (index - n) % NUMBERS.length < 0 ? (index - n) % NUMBERS.length + NUMBERS.length : (index - n) % NUMBERS.length;
        } else {
            index = c - ALPHABET[0];
            indexShift = (index - n) % ALPHABET.length < 0 ? (index - n) % ALPHABET.length + ALPHABET.length : (index - n) % ALPHABET.length;
        }
        return Character.isDigit(c) ? NUMBERS[indexShift] : ALPHABET[indexShift];
    }

    public String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(decryptChar(input.charAt(i)));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MyCaesar myCaeser = new MyCaesar(22);
        System.out.println(myCaeser.encryptChar('2'));
        System.out.println(myCaeser.decryptChar(myCaeser.encryptChar('2')));
        System.out.println(myCaeser.encrypt("HELLO WORLD 1234567890"));
        System.out.println(myCaeser.decrypt(myCaeser.encrypt("HELLO WORLD 1234567890")));
    }
}