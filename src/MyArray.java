import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {
    private int[] arr;

    public MyArray(int[] arr) {
        this.arr = arr;
    }

    public int[] toArray(List<Integer> list) {
        int[] arrNew = new int[list.size()];
        for (int i = 0; i < arrNew.length; i++) {
            arrNew[i] = list.get(i);
        }
        return arrNew;
    }

    public int[] mirror() {
        int len = arr.length;
        int[] arrNew = new int[len * 2];
        for (int i = 0; i < len; i++) {
            arrNew[i] = arr[i];
            arrNew[i + len] = arr[len - i - 1];
        }
        return arrNew;
    }

    public int[] removeDuplicates() {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        return toArray(list);

    }

    public int[] getMissingValues() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i - 1] + arr[i + 1]) / 2 != arr[i]) {
                list.add((arr[i - 1] + arr[i + 1]) / 2);
            }
        }
        return toArray(list);
    }

    public int[] fillMissingValues(int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                int left = i - k / 2;
                int right = i + k / 2;
                if (k % 2 == 0) {
                    if (left < 0) {
                        left = 0;
                        right = k;
                    }
                    if (right > arr.length - 1) {
                        left = arr.length - k - 1;
                        right = arr.length - 1;
                    }
                    arr[i] = (int) averageOfTotal(left, right, k);
                } else {
                    int subLeft = left - 1;
                    int incRight = right + 1;
                    if (subLeft < 0) {
                        subLeft = 0;
                        right = k;
                    }
                    if (incRight > arr.length - 1) {
                        left = arr.length - k - 1;
                        incRight = arr.length - 1;
                    }
                    if (i == 0) {
                        arr[i] = (int) averageOfTotal(1, right, k);
                    } else if (i == arr.length - 1) {
                        arr[i] = (int) averageOfTotal(arr.length - 1 - k, arr.length - 1, k);
                    } else {
                        arr[i] = (int) Math.min(averageOfTotal(subLeft, right, k), averageOfTotal(left, incRight, k));
                    }
                }
            }
        }
        return arr;
    }

    public float averageOfTotal(int start, int end, int k) {
        int sum = 0;
        for (int j = start; j <= end; j++) {
            sum += arr[j];
        }
        return (float) (sum + 1) / k;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{10, 11, 12, 13, 14, 16, 17, 19, 20});
        MyArray myArray2 = new MyArray(new int[]{10, 11, 12, 13, 14, 16, 17, 19, 20});
        System.out.println(Arrays.toString(myArray.mirror()));
        System.out.println(Arrays.toString(myArray.removeDuplicates()));
        System.out.println(Arrays.toString(myArray2.getMissingValues()));
        System.out.println(Arrays.toString(myArray.fillMissingValues(3)));
    }


}