package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc101IsSymmetric {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetricEqualLevel(root, root);
        }

        boolean isSymmetricEqual(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return t1.val == t2.val && isSymmetricEqual(t1.left, t2.right) && isSymmetricEqual(t1.right, t2.left);
        }

        boolean isSymmetricEqualLevel(TreeNode t1, TreeNode t2) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(t1);
            q.add(t2);
            while (!q.isEmpty()) {
                t1 = q.poll();
                t2 = q.poll();

                if (t1 == null && t2 == null) {
                    continue;
                }
                if (t1 == null || t2 == null || t1.val != t2.val) {
                    return false;
                }

                q.add(t1.left);
                q.add(t2.right);

                q.add(t1.right);
                q.add(t2.left);
            }

            return true;
        }

        /**
         * 不通过，要考虑的情况过多
         */
        boolean isSymmetricEqualIter(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            TreeNode[] stack1 = new TreeNode[1001];
            int i1 = 0;
            TreeNode[] stack2 = new TreeNode[1001];
            int i2 = 0;
            TreeNode cur1 = t1;
            TreeNode cur2 = t2;
            while (cur1 != null && cur2 != null) {
                int val1 = cur1.val;
                int val2 = cur2.val;
                if (val1 != val2) {
                    return false;
                }

                boolean goLeft = false;
                boolean goRight = false;
                if (cur1.left != null) {
                    stack1[i1++] = cur1;
                    cur1 = cur1.left;
                    goLeft = true;
                } else if (cur1.right != null) {
                    cur1 = cur1.right;
                    goRight = true;
                } else {
                    cur1 = null;
                    while (i1 > 0) {
                        TreeNode temp = stack1[--i1];
                        if (temp != null && temp.right != null) {
                            cur1 = temp.right;
                            break;
                        }
                    }
                }

                if (goLeft) {
                    stack2[i2++] = cur2;
                    cur2 = cur2.right;
                } else if (goRight) {
                    stack2[i2++] = cur2.right;
                    cur2 = cur2.left;
                } else {
                    cur2 = null;
                    while (i2 > 0) {
                        TreeNode temp = stack2[--i2];
                        if (temp != null && temp.left != null) {
                            cur2 = temp.left;
                            break;
                        }
                    }
                }
            }

            return cur1 == null && cur2 == null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = TreeNode.buildFromArray(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TestCaseUtils.testCase(t1, solution::isSymmetric, true);

        TreeNode t2 = TreeNode.buildFromArray(new Integer[]{1, 2, 2, null, 3, null, 3});
        TestCaseUtils.testCase(t2, solution::isSymmetric, false);

        TreeNode t3 = TreeNode.buildFromArray(new Integer[]{1, 2, 2, 3, null, null, 3});
        TestCaseUtils.testCase(t3, solution::isSymmetric, true);

        TreeNode t4 = TreeNode.buildFromArray(new Integer[]{2, 3, 3, null, 5, 5, 4});
        TestCaseUtils.testCase(t4, solution::isSymmetric, false);
    }

}
