package cn.eamon.leetcode101_200;

import cn.eamon.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 16:04
 */
public class Num141HasCycle {
    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 哈希表
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
