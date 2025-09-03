
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0), current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}

/*
解題思路：
1. 題目要求合併 k 個排序鏈結串列成一個排序鏈結串列。
2. 使用最小堆 (PriorityQueue) 追蹤當前所有鏈結串列的最小節點：
   - 將每個非空鏈結串列的頭節點加入最小堆。
   - 每次取出最小節點加入結果，並把該節點的下一個節點加入堆。
3. 重複上述步驟直到堆空。
4. 使用虛擬頭節點(dummy)簡化鏈結串列操作。
5. 時間複雜度 O(N log k)，N 為總節點數，k 為鏈結串列數量；每次堆操作 log k。
6. 空間複雜度 O(k)，堆最多存 k 個節點。
 */
