package class03;

import java.util.Arrays;

public class Code01_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, R, mid);
    }
    public static void merge(int[] arr, int L, int R, int mid) {
        int lp = L;
        int rp = mid + 1;
        int[] helper = new int[R - L + 1];
        int hi = 0;
        while (lp <= mid && rp <= R) {
            if (arr[lp] < arr[rp]) {
                helper[hi++] = arr[lp];
                lp++;
            } else {
                helper[hi++] = arr[rp];
                rp++;
            }
        }
        while (lp <= mid) {
            helper[hi++] = arr[lp++];
        }
        while (rp <= R) {
            helper[hi++] = arr[rp++];
        }

        System.arraycopy(helper, 0, arr, L, R - L + 1);
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int mergeSize = 1;
        while (mergeSize < arr.length) {
            int L = 0;
            while (L < arr.length) {
                int mid = (L + mergeSize) - 1;
                if (mid >= arr.length) {
                    break; // 左组不够跳出
                }
                int R = Math.min(mid + mergeSize, arr.length - 1);
                merge(arr,L, R, mid);
                L = R + 1;
            }
            // 用于防止超过整数最大值
            if (mergeSize > arr.length / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] ints = {6, 3, 7, 9};
        mergeSort(ints);
        System.out.println(Arrays.toString(ints));
//        System.arraycopy(new int[] {1, 2}, 0, ints, 0, 1 - 0 + 1);
//        System.out.println(Arrays.toString(ints));

    }
}
