package class04;

/**
 * @author ErrorRua
 * @date 2023/07/13
 * @description:
 */
public class Code02_ReverseKGroup {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = randomList(10, 10);
        printList(listNode);
        ListNode kNode = solution.reverseKGroup(listNode, 3);
        System.out.println(kNode.val);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode end = getKNode(head, k);
            if (end == null) {
                return head;
            }
            ListNode node = head;
            reverse(head, end);
            head = end;
            while (node.next != null) {
                end = getKNode(node, k);
                if (end == null) {
                    return head;
                }
                reverse(node, end);
            }
            return head;
        }

        public ListNode getKNode(ListNode node, int k) {
            while (k != 1 && node != null) {
                node = node.next;
                k--;
            }
            return node;
        }

        public void reverse(ListNode start, ListNode end) {
            ListNode pre = null, next = null;
            ListNode cur = start;
            end = end.next;
            while (cur != end) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            start.next = end;
        }
    }
}
