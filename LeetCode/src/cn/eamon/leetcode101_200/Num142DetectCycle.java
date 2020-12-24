package cn.eamon.leetcode101_200;

import cn.eamon.utils.ListNode;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 16:47
 */
public class Num142DetectCycle {

    /**
     * 快慢指针解决
     * 方法二 用hashSet解决，同141题
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        head.next.next = new ListNode(0);
        ListNode head4 = new ListNode(-4);
        head.next.next.next = head;
        head4.next = head2;

        ListNode listNode = Num142DetectCycle.detectCycle(head);
        assert listNode != null;
        System.out.println(listNode.val);

    }
}
