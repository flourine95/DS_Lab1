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
        int index = 0;
        int[] arrNew = new int[arr.length];
        for (int value : arr) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (value == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arrNew[index++] = value;
            }
        }
        int[] res = new int[index];
        System.arraycopy(arrNew, 0, res, 0, res.length);
        return res;
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
        // Tìm vị trí của các giá trị bị thiếu
        List<Integer> missingValues = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                missingValues.add(i);
            }
        }

        // Duyệt qua các giá trị bị thiếu
        for (Integer missingValue : missingValues) {
            // nếu k == 1 thì kiểm tra xem phần tử kế bên nào nhỏ hơn thì lấy
            if (k == 1) {
                arr[missingValue] = Math.min(arr[Math.max(missingValue - 1, 0)], arr[Math.min(missingValue + 1, arr.length - 1)]);
            }
            // Tính trung bình nhỏ nhất của k giá trị gần nhất
            int sum = 0;
            int count = 0;
            int left;
            int right;
            if (missingValue + k > arr.length - 1) {
                right = arr.length - 1;
                left = right - k;
            } else if (missingValue - k < 0) {
                left = 0;
                right = left + k;
            } else {
                left = missingValue - k;
                right = missingValue + k;
            }
            for (int j = left; j <= right; j++) {
                if (arr[j] != -1) {
                    sum += arr[j];
                    count++;
                }
            }
            arr[missingValue] = sum / Math.max(count, 1);
        }

        return arr;
    }




}