package class05;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ErrorRua
 * @date 2023/07/16
 * @description:
 */
public class Code06_CreateTree {
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

    public static TreeNode createTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> headTable = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            headTable.put(inorder[i], i);
        }


        return create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode create(int[] pre, int pl, int pr, int[]in, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pl]);
        if (pl == pr) {
            return head;
        }
        int search = il;
        while (in[search] != pre[pl]) {
            search++;
        }

        head.left = create(pre, pl + 1, pl + (search - il), in, il, search - 1);
        head.right = create(pre, pl + (search - il) + 1, pr, in, search + 1, ir);
        return head;
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 5, 3, 6, 7};
        int[] ints1 = {4, 2, 5, 1, 6, 3, 7};
        TreeNode tree = createTree(ints, ints1);

        TreeNode.in(tree);
        System.out.println();
        TreeNode.pre(tree);
    }
}
