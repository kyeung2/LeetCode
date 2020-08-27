package io.nimbus.leetcode.recursion1.recurrencerelation;

import io.nimbus.leetcode.recursion1.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/
 */
public class ReverseLinkedList {

    // couldn't get the recursive on my own..
    // good explanation of the logic https://www.youtube.com/watch?v=MRe3UsRadKw
    public ListNode reverseList_recursive(ListNode head) {

        // base case, head.next == null, i.e. the tail
        if (head == null || head.next == null) return head;

        // with list 1->2->3->4->null
        ListNode p = reverseList_recursive(head.next);

        // call stack 3 head==3, head.next==4
        // 3->4->null
        // 3->4->3
        // 4->3->null
        // so over all now it is 4->3<-2<-1

        // call stack 2 head==2, head.next==3
        //  2->3
        // 2->3->2
        // 3->2
        // so over all now it is 4->3->2<-1

        // then finally will become so over all now it is 4->3->2->1
        head.next.next = head;
        head.next = null;

        // p is the tail.
        return p;
    }


    // I have trouble seeing this myself. Once the solution is in front of me fine, but I get mixed up with the pointers
    public ListNode reverseList_clean_iterative(ListNode head) {

        ListNode prev = null;// the ListNode object doesn't have a pointer to the previous so we have to maintain it
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;// this will be overwritten so store it
            curr.next = prev; // simply point to the previous

            // prep for the next iteration
            prev = curr; // the current becomes the previous for the next iteration.
            curr = temp;// next iteration will traverse the list in the original order.
        }
        return prev;
    }


    // dumb iterative approach using a stack
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode n = head;
        while (n != null) {
            stack.push(n);
            n = n.next;
        }

        ListNode m = stack.pop();
        ListNode newHead = m;
        while (!stack.isEmpty()) {
            m.next = stack.pop();
            m = m.next;
            if (stack.isEmpty()) {
                m.next = null;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode reversed = new ReverseLinkedList().reverseList(head);
        System.out.println(reversed);
    }

}
