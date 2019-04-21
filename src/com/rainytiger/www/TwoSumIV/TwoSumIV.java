package com.rainytiger.www.TwoSumIV;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoSumIV {

    private void goAlongLeftBranch(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private List<Integer> inorderTraversal(TreeNode root) {
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

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> arr = inorderTraversal(root);
        int left = 0, right = arr.size() - 1;
        while (left != right) {
            int temp = arr.get(left) + arr.get(right);
            if (temp > k) {
                right--;
            } else if (temp < k) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
