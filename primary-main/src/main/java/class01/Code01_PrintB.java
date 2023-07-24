package class01;

/**
 * @author ErrorRua
 * @date 2023/07/11
 * @description:
 */
public class Code01_PrintB {
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(( num & (1 << i) ) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println();
        print(Integer.MIN_VALUE);
        print(~Integer.MIN_VALUE);
        print(-Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);


    }
}
