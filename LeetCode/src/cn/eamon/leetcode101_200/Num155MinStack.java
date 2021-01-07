package cn.eamon.leetcode101_200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/30 17:02
 */
public class Num155MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    int minVal;

    /**
     * initialize your data structure here.
     */
    public Num155MinStack() {
        minVal = Integer.MAX_VALUE;
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(minVal);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
