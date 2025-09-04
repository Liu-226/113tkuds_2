
import java.util.*;

class Solution {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null, curr = start;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            ListNode kth = prevGroup;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;

            ListNode newHead = reverse(groupStart, nextGroup);

            prevGroup.next = newHead;
            groupStart.next = nextGroup;

            prevGroup = groupStart;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode dummy = new ListNode(0), cur = dummy;
        while (sc.hasNextInt()) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }

        Solution sol = new Solution();
        ListNode result = sol.reverseKGroup(dummy.next, k);

        cur = result;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" ");
            }
            cur = cur.next;
        }
        System.out.println();
    }
}
