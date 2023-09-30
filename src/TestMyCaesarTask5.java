
public class TestMyCaesarTask5 {
    public static void main(String[] args) {
        new MyCaesar(3).encrypt(
                "D:\\CodeInLab\\DSA\\DS_Lab1\\src\\input.txt",
                "D:\\CodeInLab\\DSA\\DS_Lab1\\src\\output.txt");
        new MyCaesar(3).decrypt(
                "D:\\CodeInLab\\DSA\\DS_Lab1\\src\\output.txt",
                "D:\\CodeInLab\\DSA\\DS_Lab1\\src\\output2.txt");
    }
}
