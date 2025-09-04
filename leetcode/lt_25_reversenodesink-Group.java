
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 題目：Reverse Nodes in k-Group
// 給定一個鏈結串列 head，每次反轉 k 個節點，並回傳反轉後的鏈結串列。
// 如果最後剩餘節點數小於 k，則保持原樣。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 建立 dummy 節點方便操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 找到目前 group 的結尾
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) {
                break; // 剩下不足 k 個節點，結束
            }
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 斷開目前 group
            kth.next = null;

            // 反轉 group
            prevGroupEnd.next = reverse(groupStart);

            // groupStart 現在是反轉後的尾巴
            groupStart.next = nextGroupStart;

            // 移動 prevGroupEnd 指標到新的尾巴
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // 幫助函式：取得從 node 開始往後第 k 個節點
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    // 幫助函式：反轉一個鏈結串列，回傳新頭
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

/*
解題思路：
1. 使用 dummy 節點簡化操作，prevGroupEnd 指向每個分組前的節點。
2. 每次檢查是否還有 k 個節點可反轉，若不足則直接結束。
3. 使用輔助函式 reverse() 反轉每一組 k 節點。
4. 將反轉後的尾巴（原 groupStart）連接到下一組的頭節點。
5. 重複直到鏈結串列結束。
6. 時間複雜度 O(n)，空間複雜度 O(1)。
 */
