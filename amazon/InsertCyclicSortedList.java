/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }
        if (node.next == node) {
            newNode.next = node;
            node.next = newNode;
            return newNode;
        }

        // find the largest node
        ListNode max = node;
        while (max.val <= max.next.val) {
            max = max.next;
            if (max.next == node) { // handle the case 2->2->2
                break;
            }
        }

        ListNode pre = max;
        ListNode curr = max.next;
        while (curr.val < x) {
            pre = curr;
            curr = curr.next;
            if (curr == max.next) { // go back to the start point
                break;
            }
        }
        newNode.next = curr;
        pre.next = newNode;
        return newNode;
    }
}
