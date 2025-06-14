package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc145PostorderTraversal {

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(root, list);
            return list;
        }

        public void traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            traversal(root.left, list);
            traversal(root.right, list);
            list.add(root.val);
        }

        public List<Integer> postorderTraversalIter(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode last = null;

            while (root != null) {
                if (root.left != null) {
                    stack.push(root);
                    root = root.left;
                    continue;
                }

                if (root.right != null) {
                    stack.push(root);
                    root = root.right;
                    continue;
                }

                list.add(root.val);
                last = root;

                root = null;
                while (!stack.empty()) {
                    root = stack.pop();
                    if (last == root.right || root.right == null) {
                        list.add(root.val);
                        last = root;
                    } else {
                        stack.push(root);
                        root = root.right;
                        break;
                    }
                }
                if (stack.empty()) {
                    break;
                }
            }

            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = TreeNode.buildFromArray(new Integer[]{1, null, 2, null, null, 3});
        List<Integer> e1 = new ArrayList<>(List.of(3, 2, 1));
        TestCaseUtils.testCase(t1, solution::postorderTraversal, e1);

        TreeNode t2 = TreeNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        List<Integer> e2 = new ArrayList<>(List.of(4, 6, 7, 5, 2, 9, 8, 3, 1));
        TestCaseUtils.testCase(t2, solution::postorderTraversalIter, e2);
    }
}
