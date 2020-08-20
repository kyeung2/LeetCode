package io.nimbus.leetcode.topinterviewquestionseasy.linkedlists;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
 */
public class DeleteNodeInALinkedList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



    // didn't understand this question. so all they are doing is shifting what the current
    // node is pointer at (data + next) to what it's next is pointer out. A little silly
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

}


