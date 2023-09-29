public class MyCaesar {

    public static final char[] ALPHABET = {
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private int n;// shift steps (right shift)

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    public char encryptChar(char c) {
        if (new String(ALPHABET).indexOf(c) < 0) {
            return c;
        }
        int index = c - ALPHABET[0];
        int indexShift = (index + n) % ALPHABET.length;
        if (indexShift < 0) {
            indexShift += ALPHABET.length;
        }
        return ALPHABET[indexShift];
    }

    public String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(encryptChar(input.charAt(i)));
        }
        return result.toString();
    }

    public char decryptChar(char c) {
        if (new String(ALPHABET).indexOf(c) < 0) {
            return c;
        }
        int index = c - ALPHABET[0];
        int indexShift = (index - n) % ALPHABET.length;
        if (indexShift < 0) {
            indexShift += ALPHABET.length;
        }
        return ALPHABET[indexShift];
    }

    public String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(decryptChar(input.charAt(i)));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MyCaesar myCaeser = new MyCaesar(3);
        System.out.println(myCaeser.encryptChar('A'));
        System.out.println(myCaeser.decryptChar(myCaeser.encryptChar('A')));
        System.out.println(myCaeser.encrypt("HELLO WORLD"));
        System.out.println(myCaeser.decrypt(myCaeser.encrypt("HELLO WORLD")));
    }
}