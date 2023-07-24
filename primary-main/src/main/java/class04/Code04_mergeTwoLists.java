package class04;

import java.awt.*;

/**
 * @author ErrorRua
 * @date 2023/07/13
 * @description:
 */
public class Code04_mergeTwoLists {
    public static ListNode randomList(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen) + 3;
        ListNode header = new ListNode();
        ListNode p = header;
        for (int i = 0; i < len; i++) {
            ListNode node = new ListNode();
            node.val = (int) (maxValue * Math.random());
            p.next = node;
            p = node;
        }
        return header;
    }
    public static void printList(ListNode header) {
        ListNode p = header;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
            if (p != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null || list2 == null) {
                return list1 == null ? list2 : list1;
            }
            ListNode head = list1.val <= list2.val ? list1 : list2;
            ListNode cur1 = head.next;
            ListNode cur2 = head == list1 ? list2 : list1;
            ListNode pre = head;
            while (cur2 != null && cur1 != null) {
                if (cur1.val <= cur2.val) {
                    pre.next = cur1;
                    cur1 = cur1.next;
                } else {
                    pre.next = cur2;
                    cur2 = cur2.next;
                }
                pre = pre.next;
            }

            pre.next = cur1 != null ? cur1 : cur2;

            return  head;
        }

        public int listLength(ListNode node) {
            int length = 0;
            while (node != null) {
                length++;
                node = node.next;
            }
            return length;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
        new Solution().mergeTwoLists(node, node1);
    }
}
