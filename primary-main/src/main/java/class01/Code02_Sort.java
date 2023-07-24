package class01;

import java.util.Arrays;

/**
 * @author ErrorRua
 * @date 2023/07/11
 * @description:
 */
public class Code02_Sort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1 ; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!swap) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int newIndex = i;
            while (newIndex >= 0 && arr[newIndex + 1] < arr[newIndex]) {
                int tmp = arr[newIndex];
                arr[newIndex] = arr[newIndex + 1];
                arr[newIndex + 1] = tmp;
                newIndex--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8, 6};
        selectionSort(Arrays.copyOf(arr, arr.length));
        bubbleSort(Arrays.copyOf(arr, arr.length));
        insertionSort(Arrays.copyOf(arr, arr.length));
    }
}
