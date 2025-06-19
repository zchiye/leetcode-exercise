package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc105BuildTree {

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
                return null;
            }
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        public TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
            if (prestart < 0 || preend > preorder.length || prestart >= preorder.length
                    || instart < 0 || inend > inorder.length || instart >= inorder.length) {
                return null;
            }

            int rootVal = preorder[prestart];
            TreeNode root = new TreeNode(rootVal);

            int i = -1;
            for (int j = 0; j < inend; j++) {
                if (inorder[j] == rootVal) {
                    i = j;
                    break;
                }
            }

            if (i < 0) {
                return null;
            }

            int leftlen = i - instart;
            int rightlen = inend - i - 1;

            root.left = buildTree(preorder, prestart + 1, prestart + 1 + leftlen, inorder, instart, instart + leftlen);
            root.right = buildTree(preorder, prestart + 1 + leftlen, prestart + 1 + leftlen + rightlen, inorder, i + 1, i + 1 + rightlen);

            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pre1 = new int[]{3, 9, 20, 15, 7};
        int[] in1 = new int[]{9, 3, 15, 20, 7};
        TreeNode e1 = TreeNode.buildFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        TestCaseUtils.testCase(pre1, in1, solution::buildTree, e1, Arrays::toString, Arrays::toString);

        int[] pre2 = new int[]{-1};
        int[] in2 = new int[]{-1};
        TreeNode e2 = TreeNode.buildFromArray(new Integer[]{-1});
        TestCaseUtils.testCase(pre2, in2, solution::buildTree, e2, Arrays::toString, Arrays::toString);
    }
}
