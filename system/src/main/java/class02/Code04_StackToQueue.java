package class02;

import java.util.Stack;

public class Code04_StackToQueue {
    public static class StackToQueue {
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        public void offer(int value) {
            pushStack.push(value);
        }

        public int poll() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        public int peek() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }
}
