package class05;

/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code04_SymmetricTree {
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
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        public boolean isMirror(TreeNode node1, TreeNode node2) {
            if (node1 == null ^ node2 == null) {
                return false;
            }
            if (node1 == null && node2 == null) {
                return true;
            }
            return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
    }
}
