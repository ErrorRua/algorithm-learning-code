package class05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code02_MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(this.val);
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> listNodes = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
            for (ListNode list : lists) {
                addQueue(listNodes, list);
            }
            ListNode head = listNodes.poll();


            ListNode cur = head;
            while (!listNodes.isEmpty()) {
                cur.next = listNodes.poll();
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }

        public void addQueue(PriorityQueue<ListNode> listNodePriorityQueue, ListNode head) {
            while (head != null) {
                listNodePriorityQueue.add(head);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.mergeKLists(new ListNode[]{node, node1});
    }
}
