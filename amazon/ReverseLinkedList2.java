/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        int count = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while(count < m) {
            head = head.next;
            count++;
        }

        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;

        //it is < not <= because we change pointer of m+1 to point ot m, when it is n(which is equivalent to m+1 here)
        while (count < n) {
            ListNode temp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = temp;
            count++;
        }
        preM.next = nNode;
        mNode.next = postN;
        return dummy.next;
    }
}
