/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// constant space complexity
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode cur = head;
        // duplicate each node in the original RandomListNode
        while (cur != null) {
            RandomListNode temp = cur.next;
            RandomListNode newNode  = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = temp;
            cur = temp;
        }

        // copy random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
               cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // restore the original list
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newCur, newIter = dummy;
        while (cur != null) {
            RandomListNode temp = cur.next.next;
            newCur = cur.next;
            newIter.next = newCur;
            newIter = newCur;

            cur.next = temp;
            cur = temp;
        }
        return dummy.next;
    }
}


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
