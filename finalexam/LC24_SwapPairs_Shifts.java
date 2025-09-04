
import java.util.*;

class Solution {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = a.next;

            prev.next = b;
            a.next = b.next;
            b.next = a;

            prev = a;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            return;
        }

        String[] nums = line.split(" ");
        ListNode dummy = new ListNode(0), cur = dummy;
        for (String s : nums) {
            cur.next = new ListNode(Integer.parseInt(s));
            cur = cur.next;
        }

        Solution sol = new Solution();
        ListNode swapped = sol.swapPairs(dummy.next);

        cur = swapped;
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
