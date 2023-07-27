package class02;

/**
 * @author ErrorRua
 * @date 2023/07/24
 * @description:
 */
public class Code01_List {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int v) {
            value = v;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public static class ListDoubleNode {
        public int value;
        public ListDoubleNode last;
        public ListDoubleNode next;

        public ListDoubleNode(int v) {
            value = v;
        }
    }

    public static ListNode reverse(ListNode head) {

        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static ListDoubleNode reverse(ListDoubleNode head) {
        ListDoubleNode next = null;
        ListDoubleNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static ListNode deleteNum(ListNode head, int num) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.value == num) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static ListNode removeNum(ListNode head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode5 = deleteNum(listNode3, 1);
        System.out.println(1);
    }
}
