package cn.eamon.leetcode201_300;

import cn.eamon.utils.ListNode;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 15:08
 */
public class Num206ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
