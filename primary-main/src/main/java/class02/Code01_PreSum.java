package class02;

/**
 * @author ErrorRua
 * @date 2023/07/12
 * @description:
 */
public class Code01_PreSum {
    public static void main(String[] args) {

    }
}
class PreSum {
    private int[] sumArr;

    PreSum(int[] arr) {
        // 生成 0-n 累加的数组
        sumArr = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            sumArr[i] += arr[i + 1];
        }
    }

    public int preSum(int left, int right) {
        return left == 0 ? sumArr[right] : sumArr[right] - sumArr[left - 1];
    }
}