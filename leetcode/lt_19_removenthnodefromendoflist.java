
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
// 題目：Remove N-th Node From End of List
// 給定一個鏈結串列 head，刪除倒數第 n 個節點，並回傳新的 head。

// 定義鏈結串列節點
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}

/*
解題思路：
1. 我們需要刪除「倒數第 n 個節點」，但鏈結串列無法直接反向走訪，因此使用「雙指標」技巧。
2. 新建一個虛擬頭節點(dummy)，指向 head，避免刪除頭節點時需要特判。
3. 讓 fast 指標先移動 n+1 步，這樣 slow 與 fast 之間剛好相差 n 個節點。
4. 接著同步移動 fast 與 slow，直到 fast 抵達尾端。此時 slow 的位置剛好在「待刪除節點」的前一個。
5. 透過 slow.next = slow.next.next，完成刪除操作。
6. 回傳 dummy.next 作為新 head。
7. 時間複雜度 O(sz)，只需要一次遍歷；空間複雜度 O(1)。
*/
