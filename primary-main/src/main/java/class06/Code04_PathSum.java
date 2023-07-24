package class06;

/**
 * @author ErrorRua
 * @date 2023/07/17
 * @description:
 */
public class Code04_PathSum {
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

        public static boolean isSum = false;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            process(root, 0, targetSum);
            return isSum;
        }

        public void process(TreeNode root, int preSum, int targetSum) {
            if (root.left == null && root.right == null) {
                if (preSum + root.val == targetSum){
                    isSum = true;
                }
                return;
            }

            if (root.left != null){
                process(root.left, preSum + root.val, targetSum);
            }

            if (root.right != null){
                process(root.right, preSum + root.val, targetSum);
            }
        }
    }
}
