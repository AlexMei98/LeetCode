package com.rainytiger.www.BinaryTree;

import java.util.*;

public class Solution {

    private boolean hasRChild(TreeNode root) {
        return root.right != null;
    }

    private boolean hasLChild(TreeNode root) {
        return root.left != null;
    }

    private void visitAlongLeftBranch(TreeNode root, Stack<TreeNode> stack, List<Integer> ret) {
        while (root != null) {
            ret.add(root.val);
            stack.push(root.right);
            root = root.left;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            visitAlongLeftBranch(root, stack, ret);
            if (stack.empty()) break;
            root = stack.pop();
        }
        return ret;
    }

    private void goAlongLeftBranch(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            goAlongLeftBranch(root, stack);
            if (stack.empty()) break;
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }
        return ret;
    }

    private void gotoHLVFL(Stack<TreeNode> stack) {
        TreeNode temp = stack.peek();
        while (temp != null) {
            if (hasLChild(temp)) {
                if (hasRChild(temp)) stack.push(temp.right);
                stack.push(temp.left);
            } else {
                stack.push(temp.right);
            }
            temp = stack.peek();
        }
        stack.pop();
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            if (root != stack.peek().left && root != stack.peek().right) {
                gotoHLVFL(stack);
            }
            root = stack.pop();
            ret.add(root.val);
        }
        return ret;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = queue.size();
        while (!queue.isEmpty()) {
            root = queue.remove();
            if (hasLChild(root)) queue.add(root.left);
            if (hasRChild(root)) queue.add(root.right);
            temp.add(root.val);
            if (--length == 0) {
                ret.add(temp);
                temp = new ArrayList<>();
                length = queue.size();
            }
        }
        return ret;
    }

}
