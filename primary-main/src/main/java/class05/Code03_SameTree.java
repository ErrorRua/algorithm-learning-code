package class05;


/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code03_SameTree {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {

            if (p == null ^ q == null) { // 逻辑运算异或 相异为真，相同为假
                return false;
            }
            if (p == null && q == null) {
                return true;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

        TreeNode node1 = new TreeNode(1, null, new TreeNode(1));
        TreeNode node2 = new TreeNode(1, new TreeNode(1), null);
        System.out.println(true ^ false);
        System.out.println(true ^ true);
        System.out.println(false ^ false);
    }
}
