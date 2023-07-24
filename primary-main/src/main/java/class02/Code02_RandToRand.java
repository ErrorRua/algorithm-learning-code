package class02;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * @author ErrorRua
 * @date 2023/07/12
 * @description:
 */
public class Code02_RandToRand {
    public static void main(String[] args) {
        // 等概率生成[0, 1)的数
        System.out.println(Math.random());
        // 等概率生成[0, k)的数
        int k = 8;
        System.out.println(Math.random() * k);
        // 等概率生成[0, k - 1]的数
        System.out.println((int) (Math.random() * k));


        int testTime = 1000000;
        int[] counts = new int[10];
        for (int i = 0; i < testTime; i++) {
            counts[f5()]++;
        }
        System.out.println(Arrays.toString(counts));
    }


    // 生成[0, 1)的数
    // 任意的x, x属于[0, 1)， [0, 1)范围上的数出现概率由原来的x调整为x的平方
    public static double xToPower2() {
        return Math.max(Math.random(), Math.random());
    }

    // 生成[1, 5]的数
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    // 将f1改造成等概率生成0,1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans > 3 ? 1 : 0;
    }

    // 得到 000 ~ 111 等概率 0 ~ 7
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    // 等概率 0 ~ 6
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    // 等概率 1 ~ 7
    public static int f5() {
        return f4() + 1;
    }

    // 以某种概率生成01
    public static int x() {
        return Math.random() > 0.43 ? 0 : 1;
    }

    // 等概率生成01
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }
}
