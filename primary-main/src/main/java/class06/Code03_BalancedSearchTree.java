package class06;

/**
 * @author ErrorRua
 * @date 2023/07/17
 * @description:
 */
public class Code03_BalancedSearchTree {
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
        public class info {
            boolean isBST;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            public info() {
            }
            public info(boolean isBST) {
                this.isBST = isBST;
            }

            public info(boolean isBST, int max, int min) {
                this.isBST = isBST;
                this.max = max;
                this.min = min;
            }
        }
        public boolean isValidBST(TreeNode root) {
            return isBST(root).isBST;
        }

        public info isBST(TreeNode node) {
            if (node == null) {
                return null;
            }
            info info = new info();
            info lInfo = isBST(node.left);
            info rInfo = isBST(node.right);

            boolean isBST = true;
            int max = node.val;
            int min = node.val;
            if (lInfo != null) {
                max = Math.max(lInfo.max, max);
                min = Math.min(lInfo.min, min);
                if (!lInfo.isBST) {
                    isBST = false;
                }
            }
            if (rInfo != null) {
                max = Math.max(rInfo.max, max);
                min = Math.min(rInfo.min, min);
                if (!rInfo.isBST) {
                    isBST = false;
                }
            }

            boolean leftMaxLessX = lInfo == null || lInfo.max < node.val;
            boolean rightMinMoreX = rInfo == null || rInfo.min > node.val;

            info.isBST = leftMaxLessX && rightMinMoreX && isBST;
            info.max = max;
            info.min = min;
            return info;
        }
    }
}
