package com.github.antonfermat.leetcode.templates;

public class ListNode {

    public int fastSlow(Node head) {
        Node slow = head;
        Node fast = head;
        int ans = 0;

        while (fast != null && fast.next != null) {
            // do logic
            slow = slow.next;
            fast = fast.next.next;
        }
        return ans;
    }

    public Node reverse(Node head) {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }

    static class Node {
        int val;
        Node next;
    }
}
