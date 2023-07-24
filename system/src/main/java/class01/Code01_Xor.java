package class01;

import java.nio.IntBuffer;

/**
 * @author ErrorRua
 * @date 2023/07/22
 * @description:
 */
public class Code01_Xor {
    public static void fund2(int[] arr) {
        int eor = 0;
        for(int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }

        int rightOne = eor & (-eor);

        int a = 0;
        for(int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                a = a ^ arr[i];
            }
        }
        int b = eor ^ a;

        System.out.println(a);
        System.out.println(b);
    }

    public static void fundKNum(int[] arr, int k, int m) {
        int[] bits = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = 0;
            while (num != 0) {
                bits[index++] += num & 1;
                num = num >> 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % m != 0) {
                ans |= (1 << i);
            }
        }

        System.out.println(ans);
    }

    public static int fundKNum2(int[] arr, int k, int m) {
        int[] bits = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = 0;
            while (num != 0) {
                bits[index++] += num & 1;
                num = num >> 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % m == 0) {
                continue;
            }

            if (bits[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }
        }

        if (ans == 0) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }
            if (count != m) {
                return -1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
//        fund2(arr);

//        数组里一种整数出现3次，其他整数出现6次
        int[] arr1 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 1, 1, 1, 2, 2, 2, 3, 3, 3, 0, 0, 0};
        fundKNum2(arr1, 4, 6);
    }
}
