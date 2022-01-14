package io.nimbus.leetcode.topinterviewquestions.medium;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromList_my_attempt {


    public static void main(String[] args) {


        ListNode head;
        head = new ListNode(1);
        System.out.println("scenario 1: single node, coded as a special case..." + head);
        System.out.println(new RemoveNthNodeFromList_my_attempt().removeNthFromEnd(head, 1));
        System.out.println();

        head = new ListNode(1, new ListNode(2));
        System.out.println("scenario 2: 2 nodes, remove the last node. " + head);
        System.out.println(new RemoveNthNodeFromList_my_attempt().removeNthFromEnd(head, 1));
        System.out.println();

        head = new ListNode(1, new ListNode(2));
        System.out.println("scenario 3: 2 nodes, remove the first node. " + head);
        System.out.println(new RemoveNthNodeFromList_my_attempt().removeNthFromEnd(head, 2));
        System.out.println();

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("scenario 4: 3 nodes, remove middle. " + head);
        System.out.println(new RemoveNthNodeFromList_my_attempt().removeNthFromEnd(head, 2));
        System.out.println();

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("scenario 5: 3 nodes,  first node. " + head);
        System.out.println(new RemoveNthNodeFromList_my_attempt().removeNthFromEnd(head, 3));
        System.out.println();

    }


    //TODO I got a O(n) complexity but... was a little difficult to reason the implementation.
    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode nBehindParent = null;
        ListNode nBehind = null;
        ListNode current = head;

        //TODO my "step" count is not necessary if the "current" was moved forwards on its own in a for-loop first.
        int steps = 1;
        while (current != null) {

            // assign the pointer that is exactly n behind the current.
            if (steps == n) {
                nBehind = head;
            } else {
                // then keep on stepping with the current until the end, so the delta is exactly n behind the end.
                nBehindParent = nBehind;
                nBehind = nBehind != null ? nBehind.next : null;
            }

            steps++;
            current = current.next;
        }

        if (nBehindParent != null && nBehind != null) {
            // do snipping
            nBehindParent.next = nBehind.next;
        } else if (nBehindParent == null && nBehind != null) {
            // no parent, indicating nBehind is at head.
            return nBehind.next;
        }

        return head;
    }

    private static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
