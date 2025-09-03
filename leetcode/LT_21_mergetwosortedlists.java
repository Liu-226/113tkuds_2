
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
// 題目：Merge Two Sorted Lists
// 給定兩個排序好的鏈結串列 list1 和 list2，將它們合併成一個排序好的鏈結串列，並回傳新的 head。

import java.util.*;

// 定義鏈結串列節點
class ListNode {

    int val;        // 節點值
    ListNode next;  // 下一個節點

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 將字串 "[1,2,3]" 轉換成鏈結串列
    static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", ""); // 移除中括號與空白
        if (data.isEmpty()) {
            return null;           // 空字串回傳 null

                }String[] nums = data.split(",");
        ListNode dummy = new ListNode(0);          // 虛擬頭節點方便操作
        ListNode curr = dummy;
        for (String s : nums) {
            curr.next = new ListNode(Integer.parseInt(s)); // 建立新節點
            curr = curr.next;
        }
        return dummy.next; // 回傳真正的 head
    }

    // 將鏈結串列轉換成字串 "[1,2,3]"
    static String serialize(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toString();
    }
}

// 解題主程式
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // 建立虛擬頭節點
        ListNode current = dummy;         // current 指向結果鏈結串列尾端

        // 同時遍歷 list1 與 list2
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;    // 將 list1 節點接到結果
                list1 = list1.next;      // list1 指標往後移
            } else {
                current.next = list2;    // 將 list2 節點接到結果
                list2 = list2.next;      // list2 指標往後移
            }
            current = current.next;      // 移動 current 指向結果尾端
        }

        // 如果其中一個鏈結串列還有剩餘節點，直接接上
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next; // 回傳合併後的 head
    }
}

// 測試主程式
public class Main {

    public static void main(String[] args) {
        // 反序列化輸入字串成鏈結串列
        ListNode l1 = ListNode.deserialize("[1,2,4]");
        ListNode l2 = ListNode.deserialize("[1,3,4]");

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        // 序列化結果鏈結串列並輸出
        System.out.println(ListNode.serialize(merged)); // 輸出 [1,1,2,3,4,4]
    }
}

/*
解題思路：
1. 使用虛擬頭節點(dummy)方便操作，避免特判 head。
2. 同時遍歷 list1 和 list2，逐一比較節點值，將較小的節點接到結果鏈結串列。
3. 移動對應鏈結串列的指標，直到其中一個鏈結串列走到尾端。
4. 將剩餘節點直接接到結果鏈結串列。
5. 時間複雜度 O(n+m)，n 和 m 分別是兩個鏈結串列的長度；空間複雜度 O(1)。
*/
