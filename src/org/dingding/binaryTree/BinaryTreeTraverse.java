package org.dingding.binaryTree;

import java.util.Stack;

/**
 * 二叉树 非循环遍历 前序简单，中序次之，后序最难
 * https://www.cnblogs.com/du001011/p/11229170.html
 *
 * @author dzj
 */
public class BinaryTreeTraverse {


    public static class TreeNode {
        private String value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(String value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;

        }

        public boolean hasSub() {
            return left != null || right != null;
        }

        public void print() {
            System.out.println(value);
        }

    }

    public static void main(String[] args) {
        /**
         *     A
         *   B   C
         *  D E F G
         */
        TreeNode d = new TreeNode("D", null, null);
        TreeNode e = new TreeNode("E", null, null);
        TreeNode f = new TreeNode("F", null, null);
        TreeNode g = new TreeNode("G", null, null);
        TreeNode b = new TreeNode("B", d, e);
        TreeNode c = new TreeNode("C", f, g);
        TreeNode a = new TreeNode("A", b, c);

        // traversePreOrder(a);

        // traverseInOrder(a);
        traversePostOrder(a);
    }

    public static void traversePreOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.empty()) {
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
            curr.print();
            if (!st.empty()) {
                curr = st.pop();
            }

        }

        System.out.println("\n");

    }

    public static void traverseInOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.empty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            // 因为当前元素的左节点肯定在它之前弹出（因为压栈是一直找左节点的），所以此处打印完当前节点是转到右节点
            if (!st.isEmpty()) {
                TreeNode pop = st.pop();
                pop.print();
                curr = pop.right;
            }

        }


        System.out.println("\n");

    }

    // 后续遍历好麻烦，记不住
    public static void traversePostOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
        while (curr != null || !stack.isEmpty()) {//节点不为空，结点入栈，并且指向下一个左孩子
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //栈不为空
            if (!stack.isEmpty()) {
                //出栈
                curr = stack.pop();
                /**
                 * 这块就是判断当前节点是否有右孩子，
                 * 如果没有输出当前节点的值，让lastVisit指向当前节点，并让当前节点为空，下面好从栈接着弹元素出来
                 * 如果右孩子刚刚被访问过了也是同理
                 * 如果有右孩子，将当前节点继续入栈，当前节点指向它的右孩子,继续重复循环
                 */
                if (curr.right == null || curr.right == lastVisit) {
                    curr.print();
                    lastVisit = curr;
                    curr = null;
                } else {
                    stack.push(curr);
                    curr = curr.right;
                }

            }

        }

    }

}
