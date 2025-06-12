package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc144PreorderTraversal {

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(root, list);
            return list;
        }

        public void traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            traversal(root.left, list);
            traversal(root.right, list);
        }

        public List<Integer> preorderTraversalIter(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();

            while (root != null) {
                list.add(root.val);

                if (root.left != null) {
                    stack.push(root);
                    root = root.left;
                } else if (root.right != null) {
                    root = root.right;
                } else {
                    root = null;
                    while (!stack.empty()) {
                        TreeNode temp = stack.pop();
                        if (temp != null && temp.right != null) {
                            root = temp.right;
                            break;
                        }
                    }
                }
            }

            return list;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = TreeNode.buildFromArray(new Integer[]{1, null, 2, null, null, 3});
        List<Integer> e1 = new ArrayList<>(List.of(1, 2, 3));
        TestCaseUtils.testCase(t1, solution::preorderTraversalIter, e1);

        TreeNode t2 = TreeNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        List<Integer> e2 = new ArrayList<>(List.of(1, 2, 4, 5, 6, 7, 3, 8, 9));
        TestCaseUtils.testCase(t2, solution::preorderTraversalIter, e2);
    }
}
