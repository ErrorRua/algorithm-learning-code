package class03;

public class Code02_SmallSum {


    public static int SmallSum(int[] arr) {
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
        int lp = L;
        int rp = mid + 1;
        int[] helper = new int[R - L + 1];
        int hi = 0;
        int ans = 0;
        while (lp <= mid && rp <= R) {
            if (arr[lp] < arr[rp]) {
                helper[hi++] = arr[lp];
                ans += arr[lp] * (R - rp + 1);
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

    public static void main(String[] args) {
        int[] ints = {6, 3, 7, 9};
        System.out.println(SmallSum(ints));
    }
}
