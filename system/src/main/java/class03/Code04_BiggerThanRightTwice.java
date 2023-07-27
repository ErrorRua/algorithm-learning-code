package class03;

public class Code04_BiggerThanRightTwice {
    public static int biggerTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) +
                process(arr, mid + 1, R) +
                merge(arr, L, R, mid);
    }

    public static int merge(int[] arr, int L, int R, int mid) {
        int ans = 0;
        // 目前囊括进来的数， 是从[mid + 1, windowR)
        int windowR = mid + 1;
        for (int i = L; i < mid + 1; i++) {
            while (windowR <= R) {
                if (arr[i] <= arr[windowR] * 2) {
                    break;
                }
                windowR++;
            }
            ans += windowR - mid - 1;
        }

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

        return ans;
    }
}
