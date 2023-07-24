package class05;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code01_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(1);
        queue.add(7);
        queue.add(2);
        queue.add(5);
        queue.add(4);

        System.out.println(queue.peek());
    }

    public class MyComparator implements Comparator<Integer> {

        // 负，第一个参数在前
        // 正，第二个参数在前
        // 0，谁放前都行
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }
}
