package io.nimbus.leetcode.recursion1.principleofrecursion;

import io.nimbus.leetcode.recursion1.ListNode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
 */
public class SwapNodesInPairs {


    // annoyingly (well looking at the solution, for my current insights into recursion wasn't trivial for me) I didn't get this one on my own. It seems such a simple problem but tricky implementing it.
    public ListNode swapPairs(ListNode head) {
        // I had the correct base base. But doing so on my own wasn't 100% sure.
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        // !!recurse and do for 3rd element, A->B->C, swapPairs(C). And whatever it's result is attach to A.
        head.next = swapPairs(head.next.next);

        // the trick is that the reassignment of n.next happens after the recursion. I found this difficult to
        // plan out in my head.
        n.next = head;

        // always returns B, A->B
        return n;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(head);
        var swapped = new SwapNodesInPairs().swapPairs(head);
        System.out.println(swapped);
    }
}