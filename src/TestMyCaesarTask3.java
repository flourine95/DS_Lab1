public class TestMyCaesarTask3 {
    public static void main(String[] args) {
        MyCaesar myCaeser = new MyCaesar(3);
        System.out.println(myCaeser.encryptChar('2'));
        System.out.println(myCaeser.decryptChar(myCaeser.encryptChar('2')));
        System.out.println(myCaeser.encrypt("HELLO WORLD 1234567890"));
        System.out.println(myCaeser.decrypt(myCaeser.encrypt("TOIYEUVIETNAM")));
    }
}
