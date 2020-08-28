package io.nimbus.leetcode.recursion1.conclusion;

import io.nimbus.leetcode.recursion1.ListNode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
 */
public class MergeTwoSortedLists {

    // got this one first go. But I think it can be improved with tail recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // one base case
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // wasn't too hard to get the tail recursive version either.
    public ListNode mergeTwoLists_tail(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode();
        tail(merged, l1, l2);
        return merged.next;
    }

    private void tail(ListNode merged, ListNode l1, ListNode l2) {

        // base cases
        if (l1 == null) {
            merged.next = l2;
            return;
        }
        if (l2 == null) {
            merged.next = l1;
            return;
        }

        // next iteration
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        if (l1.val < l2.val) {
            merged.next = l1;
            l1Next = l1.next;
        } else {
            merged.next = l2;
            l2Next = l2.next;
        }

        // tail recursion, recursive all is the last operation.
        tail(merged.next, l1Next, l2Next);
    }
}
