import java.util.Scanner;

public class TestMyCaesarTask4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Choose your option: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> {
                    System.out.print("Enter your string: ");
                    String input = sc.next();
                    System.out.print("Enter your shift steps: ");
                    int shiftSteps = sc.nextInt();
                    MyCaesar myCaesar = new MyCaesar(shiftSteps);
                    System.out.print("Encrypted string: " + myCaesar.encrypt(input));
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("Enter your string: ");
                    String input = sc.next();
                    System.out.print("Enter your shift steps: ");
                    int shiftSteps = sc.nextInt();
                    MyCaesar myCaesar = new MyCaesar(shiftSteps);
                    System.out.print("Decrypted string: " + myCaesar.decrypt(input));
                    System.out.println();
                }
                case 3 -> System.out.println("Goodbye!");
            }
        } while (choose != 3);
    }
}
