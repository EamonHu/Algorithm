package cn.eamon.leetcode001_100.utils;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/1 20:13
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
