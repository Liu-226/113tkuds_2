
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
// 題目：Swap Nodes in Pairs
// 給定一個鏈結串列，每兩個相鄰節點交換位置，並回傳新的 head。
// 注意：不能修改節點值，只能改變節點連結。

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 將字串 "[1,2,3,4]" 轉成鏈結串列
    static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) {
            return null;
        }
        String[] nums = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String s : nums) {
            curr.next = new ListNode(Integer.parseInt(s));
            curr = curr.next;
        }
        return dummy.next;
    }

    // 將鏈結串列轉成字串 "[2,1,4,3]"
    static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {

    public ListNode swapPairs(ListNode head) {
        // 建立虛擬頭節點，方便處理 head 被交換的情況
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;

        // 遍歷鏈結串列，每次處理兩個節點
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;       // 第一個節點
            ListNode second = current.next.next; // 第二個節點

            // 交換節點
            first.next = second.next;
            second.next = first;
            current.next = second;

            // 移動指標到下一對節點前的位置
            current = first;
        }

        return dummy.next; // 回傳新的 head
    }
}

/*
解題思路：
1. 使用虛擬頭節點(dummy)簡化 head 節點被交換的情況。
2. 遍歷鏈結串列，每次取出相鄰兩個節點 first 和 second。
3. 修改節點指向以交換兩個節點：
   - first.next 指向 second.next
   - second.next 指向 first
   - 前一節點的 next 指向 second
4. 移動指標到下一對節點的前一個位置，重複上述操作。
5. 直到鏈結串列結束或只剩一個節點。
6. 時間複雜度 O(n)，每個節點只遍歷一次。
7. 空間複雜度 O(1)，只使用常數指標變數。
 */
