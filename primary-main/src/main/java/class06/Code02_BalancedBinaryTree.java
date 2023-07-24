package class06;

/**
 * @author ErrorRua
 * @date 2023/07/17
 * @description:
 */
public class Code02_BalancedBinaryTree {
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isBalanced(root.left) &&
                    isBalanced(root.right) &&
                    Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1;
        }

        public int treeDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(treeDepth(node.left), treeDepth(node.right)) + 1;
        }

    }
}
