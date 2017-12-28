/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int num = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            num++;
        }

        int subSize = num / k;
        int extra = num % k;
        ListNode[] result = new ListNode[k];
        head = root;

        for (int i = 0; i < k; i++) {
            result[i] = head;
            // ListNode temp = head;
            for (int j = 0; j < subSize + (i < extra ? 1 : 0) - 1; j++) {
                if (head != null) {
                    head = head.next;
                }
            }

            if (head != null) {
                ListNode pre = head;
                head = head.next;
                pre.next = null;
            }
            // result[i] = temp;
        }
        return result;
    }
}
