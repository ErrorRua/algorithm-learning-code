package class02;

import java.util.IdentityHashMap;

/**
 * @author ErrorRua
 * @date 2023/07/24
 * @description:
 */
public class Code02_Stack_Queue {
    public static class Stack {
        private int[] arr;
        private int size;

        private int index;

        private int capacity;

        public Stack() {
            this(10);
        }

        public Stack(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.size = 0;
            this.index = 0;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException();
            }
            return arr[size--];
        }

        public void push(int num) {
            if (size == capacity) {
                throw new RuntimeException();
            }
            arr[size++] = num;
        }
    }

    public static class Queue{
        private int[] arr;
        private int size;

        private int begin;
        private int end;
        private int capacity;

        public Queue() {
            this(10);
        }

        public Queue(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.size = 0;
            this.begin = 0;
            this.end = 0;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException();
            }
            size--;
            int ans = arr[begin];
            begin = begin == capacity - 1 ? 0 : begin + 1;
            return ans;
        }

        public void offer(int num) {
            if (size == capacity) {
                throw new RuntimeException();
            }
            size++;
            arr[end] = num;
            end = end == capacity - 1 ? 0 : end + 1;
        }

    }
}
