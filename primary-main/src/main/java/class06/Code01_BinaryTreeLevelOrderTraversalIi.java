package class06;

import java.util.*;

/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code01_BinaryTreeLevelOrderTraversalIi {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // 前序遍历
        public static void pre(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.val);
            pre(node.left);
            pre(node.right);
        }

        // 中序遍历
        public static void in(TreeNode node) {
            if (node == null) {
                return;
            }
            in(node.left);
            System.out.print(node.val);
            in(node.right);
        }

        // 后序遍历
        private static void pos(TreeNode node) {
            if (node == null) {
                return;
            }
            pos(node.left);
            pos(node.right);
            System.out.print(node.val);
        }
    }

    static class Solution {
//        public List<List<Integer>> list = new ArrayList<>();
//        public TreeMap<Integer, List<Integer>> cen = new TreeMap<>(Comparator.reverseOrder());
//        public List<List<Integer>> levelOrderBottom(TreeNode root) {
//            create(root, 0);
//            cen.forEach((k, v) -> {
//                list.add(v);
//            });
//            return list;
//
//        }
//
//        public void create(TreeNode root, int cnt) {
//            if (root == null) {
//                return;
//            }
//            List<Integer> integers = cen.get(cnt);
//            if (integers == null) {
//                integers = new ArrayList<>();
//                cen.put(cnt, integers);
//            }
//            integers.add(root.val);
//            create(root.left, cnt + 1);
//            create(root.right, cnt + 1);
//        }
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> lists = new LinkedList<>();
            if (root == null) {
                return lists;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                while (cnt-- != 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                lists.add(0, list);
            }
            return lists;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(new Solution().levelOrderBottom(treeNode));

        int index = 0;
        int[] ints = new int[100];
        ints[index++] = 1;
        ints[index++] = 2;
        ints[index++] = 3;

        System.out.println(ints[--index]);
        System.out.println(ints[--index]);
        System.out.println(ints[--index]);


    }
}
