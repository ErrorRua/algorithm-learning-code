package class05;

/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code05_MaximumDepthOfBinaryTree {
             public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
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
             System.out.println(node.val);
             pre(node.left);
             pre(node.right);
         }

         // 中序遍历
         public static void in(TreeNode node) {
             if (node == null) {
                 return;
             }
             in(node.left);
             System.out.println(node.val);
             in(node.right);
         }

         // 后序遍历
         private static void pos(TreeNode node) {
             if (node == null) {
                 return;
             }
             pos(node.left);
             pos(node.right);
             System.out.println(node.val);
         }
     }
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
