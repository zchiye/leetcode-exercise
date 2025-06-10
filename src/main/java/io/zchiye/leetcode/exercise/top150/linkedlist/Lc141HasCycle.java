package io.zchiye.leetcode.exercise.top150.linkedlist;

public class Lc141HasCycle {

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                } else {
                    return false;
                }
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.buildFromArray(new int[]{3, 2, 0, -4});
        l1.addCycle(1);
        System.out.println(solution.hasCycle(l1));
        System.out.println(l1);

        ListNode l2 = ListNode.buildFromArray(new int[]{1, 2});
        l2.addCycle(0);
        System.out.println(solution.hasCycle(l2));
        System.out.println(l2);

        ListNode l3 = ListNode.buildFromArray(new int[]{1});
        l3.addCycle(-1);
        System.out.println(solution.hasCycle(l3));
        System.out.println(l3);
    }

}
