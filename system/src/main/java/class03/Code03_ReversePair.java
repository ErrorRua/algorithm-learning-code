package class03;

public class Code03_ReversePair {
    public static int ReversePair(int[] arr) {
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
        int lp = mid;
        int rp = R;
        int[] helper = new int[R - L + 1];
        int hi = R - L;
        int ans = 0;
        while (lp >= L && rp >= mid + 1) {
            ans += arr[lp] > arr[rp] ? (rp - mid) : 0;
            helper[hi--] = arr[lp] > arr[rp] ? arr[lp--] : arr[rp--];
        }
        while (lp >= L) {
            helper[hi--] = arr[lp--];
        }
        while (rp >= mid + 1) {
            helper[hi--] = arr[rp--];
        }

        System.arraycopy(helper, 0, arr, L, R - L + 1);

        return ans;
    }


    public static void main(String[] args) {
        int[] ints = {6, 3, 7, 9, 3, 3, 3};
        System.out.println(ReversePair(ints));
    }
}
