
import java.util.*;

class Solution {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        ListNode dummy1 = new ListNode(0), cur = dummy1;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        ListNode l1 = dummy1.next;

        ListNode dummy2 = new ListNode(0);
        cur = dummy2;
        for (int i = 0; i < m; i++) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        ListNode l2 = dummy2.next;

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        cur = merged;
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
