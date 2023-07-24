package class04;

/**
 * @author ErrorRua
 * @date 2023/07/13
 * @description:
 */
public class Code03_addTwoNumbers {
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
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int length1 = listLength(l1);
            int length2 = listLength(l2);
            ListNode longl = length1 > length2 ? l1 : l2;
            ListNode shortl = longl == l1 ? l2 : l1;

            ListNode lcur = longl;
            ListNode scur = shortl;
            int up = 0;
            ListNode pre = null;
            while (scur != null) {
                int newVal = (scur.val + lcur.val + up);
                up = newVal / 10;
                lcur.val = newVal % 10;
                pre = lcur;
                lcur = lcur.next;
                scur = scur.next;
            }
            while (lcur != null && up != 0) {
                int newVal = lcur.val + up;
                lcur.val = newVal % 10;
                up = newVal / 10;
                pre = lcur;
                lcur = lcur.next;
            }
            if (up != 0) {
                pre.next = new ListNode(up);
            }
            return longl;
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
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.addTwoNumbers(node, node1);
    }
}
