package io.zchiye.leetcode.exercise.top150.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    static TreeNode buildFromArray(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = null;
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            Integer value = values[i];
            if (value == null) {
                continue;
            }
            nodes[i] = new TreeNode(value, null, null);
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < values.length) {
                nodes[i].left = nodes[left];
            }
            if (right < values.length) {
                nodes[i].right = nodes[right];
            }
            if (i == 0) {
                root = nodes[i];
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return TreeUtils.toString(this);
    }

}
