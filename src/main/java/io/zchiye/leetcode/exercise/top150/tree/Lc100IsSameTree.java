package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

public class Lc100IsSameTree {

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == q) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1t1 = TreeNode.buildFromArray(new Integer[]{1, 2, 3});
        TreeNode t1t2 = TreeNode.buildFromArray(new Integer[]{1, 2, 3});
        TestCaseUtils.testCase(t1t1, t1t2, solution::isSameTree, true);


        TreeNode t2t1 = TreeNode.buildFromArray(new Integer[]{1, 2});
        TreeNode t2t2 = TreeNode.buildFromArray(new Integer[]{1, null, 2});
        TestCaseUtils.testCase(t2t1, t2t2, solution::isSameTree, false);

        TreeNode t3t1 = TreeNode.buildFromArray(new Integer[]{1, 2, 1});
        TreeNode t3t2 = TreeNode.buildFromArray(new Integer[]{1, 1, 2});
        TestCaseUtils.testCase(t3t1, t3t2, solution::isSameTree, false);
    }
}
