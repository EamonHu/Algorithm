package cn.eamon.leetcode001_100;


import cn.eamon.utils.ListNode;

/**
 * @Author: Eamon
 * @Description: 两数相加
 * @Date: 2020/12/1 20:12
 */
public class Num002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 链表问题要返回头结点的时候，初始化一个预先指针re，下一个节点指向头结点
         */
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            // 上一位进位
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最后一位的进位
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
}
