package class03;


import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author ErrorRua
 * @date 2023/07/12
 * @description:
 */
public class Code01_BinarySearch {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] randomArr = randomArr(20, 100);
            int index = oneMinIndex(randomArr);
            if (!checkOneMinIndex(randomArr, index)) {
                System.out.println("error");
                System.out.println(index);
                System.out.println(Arrays.toString(randomArr));
                break;
            }
        }
// [73, 29, 33, 90, 14, 51]
//        Stream.generate(() -> randomArr(20, 100))
//                .parallel().limit(100).forEach(randomArr -> {
//                    int index = oneMinIndex(randomArr);
//                    if (!checkOneMinIndex(randomArr, index)) {
//                        System.out.println("error");
//                        System.out.println(index);
//                        System.out.println(Arrays.toString(randomArr));
//                        throw new RuntimeException();
//                    }
//                });
    }

    public static int[] generateRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }


    public static int binarySearch(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) >> 1;
            if (arr[m] > num) {
                r = m - 1;
            } else if (arr[m] < num) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int l = 0, r = arr.length - 1;
        int index = -1; // 记录最左的位置
        while (l <= r) {
            int m = l + (r - l) >> 1;
            if (arr[m] >= value) {
                index = m;
                r = m - 1;
            } else if (arr[m] < value) {
                l = m + 1;
            }
        }
        return index;
    }

    public static int[] randomArr(int maxLen, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxLen) + 1];
        arr[0] = (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    public static int oneMinIndex(int[] arr) {
        if (arr.length <= 2) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] < arr[m + 1] && arr[m] < arr[m - 1]) {
                return m;
            }
            if (arr[m] > arr[m - 1]) {
                r = m;
            } else if (arr[m] > arr[m + 1]) {
                l = m;
            }
        }

        return -1;
    }

    public static boolean checkOneMinIndex(int[] arr, int index) {
        if (index != -1) {
            if (index == 0) {
                return arr[index] < arr[index + 1];
            } else if (index == arr.length - 1) {
                return arr[index] < arr[index - 1];
            } else {
                return arr[index] < arr[index + 1] && arr[index] < arr[index - 1];
            }
        }
        System.out.println("================");
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < arr[i + 1] && arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
