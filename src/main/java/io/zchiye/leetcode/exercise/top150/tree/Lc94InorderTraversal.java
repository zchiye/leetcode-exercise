package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc94InorderTraversal {

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(root, list);
            return list;
        }

        public void traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            traversal(root.left, list);
            list.add(root.val);
            traversal(root.right, list);
        }

        public List<Integer> inorderTraversalIter(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
                if (root.left != null) {
                    stack.push(root);
                    root = root.left;
                    continue;
                }

                list.add(root.val);

                if (root.right != null) {
                    root = root.right;
                } else {
                    root = null;
                    while (!stack.empty()) {
                        TreeNode temp = stack.pop();
                        list.add(temp.val);
                        if (temp.right != null) {
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
        List<Integer> e1 = new ArrayList<>(List.of(1, 3, 2));
        TestCaseUtils.testCase(t1, solution::inorderTraversalIter, e1);

        TreeNode t2 = TreeNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        List<Integer> e2 = new ArrayList<>(List.of(4, 2, 6, 5, 7, 1, 3, 9, 8));
        TestCaseUtils.testCase(t2, solution::inorderTraversalIter, e2);
    }
}
