package io.nimbus.leetcode.top100liked.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1Traversal = l1;
        ListNode l2Traversal = l2;
        ListNode first = new ListNode(0);
        ListNode current = first;
        while (l1Traversal != null || l2Traversal != null) {

            // calculate
            int value1 = l1Traversal != null ? l1Traversal.val : 0;
            int value2 = l2Traversal != null ? l2Traversal.val : 0;
            int total = current.val + value1 + value2;

            // assign curren first digit
            current.val = total % 10;


            // next iteration
            l1Traversal = l1Traversal != null ? l1Traversal.next : null;
            l2Traversal = l2Traversal != null ? l2Traversal.next : null;

            // if there is a second digit always add OR there's more to add.
            if (total > 9 || (l1Traversal != null || l2Traversal != null)) {
                current.next = new ListNode(total / 10);
                current = current.next;
            }
        }

        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}