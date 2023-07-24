package class04;

/**
 * @author ErrorRua
 * @date 2023/07/13
 * @description:
 */
public class Code01_List {
    public static class Node {
        public int value;
        public Node next;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode pre;
    }

    public static Node randomList(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen) + 1;
        Node header = new Node();
        Node p = header;
        for (int i = 0; i < len; i++) {
            Node node = new Node();
            node.value = (int) (maxValue * Math.random());
            p.next = node;
            p = node;
        }
        return header;
    }

    public static void printList(Node header) {
        Node p = header;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.value);
            p = p.next;
            if (p != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Node list = randomList(10, 10);
        printList(list);
        list = reverseList(list);
        printList(list);
    }

    // 递归反转链表
    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node next = node.next;
        Node newHead = reverseList(next);
        next.next = node;
        node.next = null;
        return newHead;
    }


}
