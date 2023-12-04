import java.util.Arrays;

public class TestMyArrTask1 {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1, 3, 5, 1, 3, 7, 9, 8});
        MyArray myArray2 = new MyArray(new int[]{10, 11, 12, 13, 14, 16, 17, 19, 20});
        System.out.println(Arrays.toString(myArray.mirror()));
        System.out.println(Arrays.toString(myArray.removeDuplicates()));
//        System.out.println(Arrays.toString(myArray2.getMissingValues()));
//        System.out.println(Arrays.toString(myArray.fillMissingValues(1)));
    }
}
