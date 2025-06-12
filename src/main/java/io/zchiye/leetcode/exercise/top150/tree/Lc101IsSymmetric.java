package io.zchiye.leetcode.exercise.top150.tree;

public class Lc101IsSymmetric {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetricEqual(root.left, root.right);
        }

        boolean isSymmetricEqual(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return t1.val == t2.val && isSymmetricEqual(t1.left, t2.right) && isSymmetricEqual(t1.right, t2.left);
        }
    }

}
