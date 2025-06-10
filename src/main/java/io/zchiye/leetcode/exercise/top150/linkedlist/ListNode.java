package io.zchiye.leetcode.exercise.top150.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public String toString() {
        Map<ListNode, Integer> visited = new HashMap<>();
        int i = 0;
        List<String> values = new ArrayList<>();
        ListNode node = this;
        Integer cycle = null;
        while (node != null) {
            values.add(String.valueOf(node.val));
            visited.put(node, i++);
            node = node.next;
            if (visited.get(node) != null) {
                cycle = visited.get(node);
                break;
            }
        }

        if (cycle == null) {
            return String.join(" -> ", values);
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int j = 0; j < values.size(); j++) {
            String value = values.get(j);
            if (j == 0) {
                sb.append(value);
            } else {
                sb.append(" -> ").append(value);
            }
            if (j == cycle) {
                start = sb.length() - (value.length() / 2 + 1);
            }
            if (j == values.size() - 1) {
                end = sb.length() - (value.length() / 2 + 1);
            }
        }
        int len = sb.length();
        sb.append('\n');
        for (int j = 0; j < len; j++) {
            if (j == start) {
                sb.append('↑');
            } else if (j == end) {
                sb.append('|');
            } else {
                sb.append(' ');
            }
        }
        sb.append('\n');
        for (int j = 0; j < len; j++) {
            if (j >= start && j <= end) {
                sb.append('-');
            } else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

}
