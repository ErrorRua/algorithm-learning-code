package class02;

import java.util.Stack;

public class Code03_GetMinStack {
    public static class GetMinStack {
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int value) {
            dataStack.push(value);
            minStack.push(minStack.peek() <= value ? minStack.peek() : value);
        }

        public int pop() {
            minStack.pop();
            return dataStack.pop();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
