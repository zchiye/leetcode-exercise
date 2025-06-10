package io.zchiye.leetcode.exercise.top150.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }


    ListNode getLast() {
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    void addCycle(int cycleIndex) {
        if (cycleIndex < 0) {
            return;
        }
        ListNode last = getLast();
        ListNode node = this;
        for (int i = 0; i < cycleIndex; i++) {
            node = node.next;
        }
        last.next = node;
    }

    static ListNode buildFromArray(int[] values) {
        ListNode start = null;
        ListNode last = null;
        for (int v : values) {
            ListNode node = new ListNode(v);
            if (last != null) {
                last.next = node;
            } else {
                start = node;
            }
            last = node;
        }
        return start;
    }

//    @Override
//    public String toString() {
//        // TODO
//        return null;
//    }

}
