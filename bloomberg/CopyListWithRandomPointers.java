/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

 // O(N) space complexity
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        // duplicate all the nodes
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }

        // copy the next pointers
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            temp = temp.next;
        }

        // copy the random pointers
        temp = head;
        while (temp != null) {
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
