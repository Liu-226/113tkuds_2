
import java.util.*;

class Solution {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            String[] nums = sc.nextLine().trim().split(" ");
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (String s : nums) {
                int val = Integer.parseInt(s);
                if (val == -1) {
                    break;
                }
                cur.next = new ListNode(val);
                cur = cur.next;
            }
            lists[i] = dummy.next;
        }

        Solution sol = new Solution();
        ListNode merged = sol.mergeKLists(lists);

        ListNode cur = merged;
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
