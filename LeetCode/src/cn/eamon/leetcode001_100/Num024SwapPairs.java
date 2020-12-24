package cn.eamon.leetcode001_100;

import cn.eamon.utils.ListNode;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 15:56
 */

public class Num024SwapPairs {
    /**
     * 递归解法
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

}
