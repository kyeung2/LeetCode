package io.nimbus.leetcode.top100interview.medium;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromList {


    public static void main(String[] args) {


        ListNode head;
        head = new ListNode(1);
        System.out.println("scenario 1: single node, coded as a special case..." + head);
        System.out.println(new RemoveNthNodeFromList().removeNthFromEnd(head, 1));
        System.out.println();

        head = new ListNode(1, new ListNode(2));
        System.out.println("scenario 2: 2 nodes, remove the last node. " + head);
        System.out.println(new RemoveNthNodeFromList().removeNthFromEnd(head, 1));
        System.out.println();

        head = new ListNode(1, new ListNode(2));
        System.out.println("scenario 3: 2 nodes, remove the first node. " + head);
        System.out.println(new RemoveNthNodeFromList().removeNthFromEnd(head, 2));
        System.out.println();

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("scenario 4: 3 nodes, remove middle. " + head);
        System.out.println(new RemoveNthNodeFromList().removeNthFromEnd(head, 2));
        System.out.println();

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("scenario 5: 3 nodes,  first node. " + head);
        System.out.println(new RemoveNthNodeFromList().removeNthFromEnd(head, 3));
        System.out.println();

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        //TODO same idea that I had but much more pretty.
        ListNode fast = head, slow = head;

        // TODO one of the key insights is that they made the "fast" lane move forwards first!
        for (int i = 0; i < n; i++) fast = fast.next;

       //TODO they also have a special case, where if the "fast" is the FIRST NODE head.next. This is the most
        // none intuitive part of the solution...
        if (fast == null) return head.next;

        // TODO then moved the rest in concert
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //TODO then does the snip as I did.
        slow.next = slow.next.next;
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
