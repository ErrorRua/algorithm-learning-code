package class06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ErrorRua
 * @date 2023/07/17
 * @description:
 */
public class Code05_PathSumLi {
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

        public static List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return ans;
            }
            process(root, targetSum, new LinkedList<>());
            return ans;
        }

        public void process(TreeNode root, int targetSum, LinkedList<Integer> path) {
            if (root.left == null && root.right == null) {
                if (root.val == targetSum){
                    LinkedList<Integer> list = new LinkedList<>(path);
                    list.addLast(root.val);
                    ans.add(list);
                }
                return;
            }


        }
    }
}
