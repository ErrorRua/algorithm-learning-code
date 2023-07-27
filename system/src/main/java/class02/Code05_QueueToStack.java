package class02;

import java.util.*;

public class Code05_QueueToStack {
    public static class QueueToStack {
        private LinkedList<Integer> AQueue = new LinkedList<>();
        private LinkedList<Integer> BQueue = new LinkedList<>();

        private boolean flag = true;

        public void push(int value) {
            LinkedList<Integer> offerQueue = flag ? AQueue : BQueue;
            offerQueue.offer(value);
        }

        public Integer pop() {
            LinkedList<Integer> offerQueue = flag ? AQueue : BQueue;
            LinkedList<Integer> pollQueue = !flag ? AQueue : BQueue;

            while (offerQueue.size() > 1) {
                pollQueue.offer(offerQueue.poll());
            }
            flag = !flag;

            return offerQueue.poll();
        }

        public Integer peek () {
            LinkedList<Integer> offerQueue = flag ? AQueue : BQueue;
            LinkedList<Integer> pollQueue = !flag ? AQueue : BQueue;

            while (offerQueue.size() > 1) {
                pollQueue.offer(offerQueue.poll());
            }
            Integer peek = offerQueue.pop();
            pollQueue.offer(peek);
            flag = !flag;
            return peek;
        }
    }

    public static class MyStack {
        private final Queue<Integer> queue1 = new LinkedList<>();
        private final Queue<Integer> queue2 = new LinkedList<>();
        private Queue<Integer> 存放元素队列 = queue1;
        private Queue<Integer> 辅助队列 = queue2;
        public MyStack() {
            //构造方法
        }

        //将元素 x 压入栈顶
        public void push(int x) {
            存放元素队列.offer(x);
        }

        //移除并返回栈顶元素
        public int pop() {
            //因为题目说明了每次调用 pop 和 top 都保证栈不为空，所以不用考虑栈为空的情况
            int size = 存放元素队列.size();
            for (int i = 0; i < size - 1; i++) {
                int e = 存放元素队列.poll();
                辅助队列.offer(e);
            }
            int ans = 存放元素队列.poll();
            Queue<Integer> t = 存放元素队列;
            存放元素队列 = 辅助队列;
            辅助队列 = t;
            return ans;
        }

        //返回栈顶元素
        public int peek() {
            int size = 存放元素队列.size();
            for (int i = 0; i < size - 1; i++) {
                int e = 存放元素队列.poll();
                辅助队列.offer(e);
            }
            int ans = 存放元素队列.poll();
            辅助队列.offer(ans);

            Queue<Integer> t = 存放元素队列;
            存放元素队列 = 辅助队列;
            辅助队列 = t;
            return ans;
        }

        //如果栈是空的，返回 true ；否则，返回 false
        public boolean empty() {
            if (存放元素队列.isEmpty() && 辅助队列.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    public static Random random = new Random();

    public static int randomModel() {
        return random.nextInt(3);
    }

    public static void test() {
        final int max_size = 100;
        final int test_time = 1000;


        for (int i = 0; i < test_time; i++) {
            Stack<Integer> stack = new Stack<>();
            MyStack myStack = new MyStack();
            QueueToStack queueToStack = new QueueToStack();

            for (int j = 0; j < max_size; j++) {
                switch (randomModel()) {
                    case 0 -> {
                        int nextInt = random.nextInt();
                        stack.push(nextInt);
                        queueToStack.push(nextInt);
                    }
                    case 1 -> {
                        if (stack.isEmpty()) {
                            continue;
                        }
                        Integer pop = stack.pop();
                        Integer pop1 = queueToStack.pop();
                        if (!pop.equals(pop1))  {
                            System.out.println(123123);
                        }
                    }
                    case 2 -> {
                        if (stack.isEmpty()) {
                            continue;
                        }
                        Integer pop = stack.peek();
                        Integer pop1 = queueToStack.peek();
                        if (!pop.equals(pop1))  {
                            System.out.println(123123);
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer a = 123123;
        Integer b = 123123;

        map.put(a, 123123);
        System.out.println(map.containsKey(b));

        final class Person {
            private final String name;

            Person(String name) {
                this.name = name;
            }

            public String name() {
                return name;
            }

        }
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        HashMap<Person, String> map1 = new HashMap<>();
        map1.put(person1, "123");
        System.out.println(map1.containsKey(person2));

    }
}
