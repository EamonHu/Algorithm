package cn.eamon.leetcode001_100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/30 17:26
 */
public class Num084LargestRectangleArea {

    /**
     * 方法五
     * 单调栈+哨兵  常数级优化
     */
    public int largestRectangleArea5(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        heights = newHeights;
        len += 2;

        int area = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 0; i < len; i++) {
            while (heights[deque.peekLast()] > heights[i]) {
                int height = heights[deque.removeLast()];
                int width = i - deque.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            deque.addLast(i);
        }
        return area;
    }

    /**
     * 方法四：
     * 单调栈
     */
    public int largestRectangleArea4(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            area = Math.max(area, width * height);
        }
        return area;
    }

    /**
     * 方法三：
     * 暴力法：固定一根柱子，向两边扩散求解，求出每根柱子构成的最大面积
     */
    public int largestRectangleArea3(int[] heights) {
        int area = 0;
        int len = heights.length;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i;
            int right = i;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                left--;
            }
            while (right + 1 < len && heights[right + 1] >= height) {
                right++;
            }
            area = Math.max(area, (right - left + 1) * height);
        }
        return area;
    }

    /**
     * 方法二：
     * 暴力法优化：O(n^2) 先固定一个柱子，枚举后面每根柱子，求出最大面积
     */
    public int largestRectangleArea2(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                height = Math.min(height, heights[j]);
                area = Math.max(area, (j - i + 1) * height);
            }
        }
        return area;
    }

    /**
     * 方法一
     * 暴力法：O(n^3) 不通过
     */
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int height = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    height = Math.min(height, heights[k]);
                }
                area = Math.max(area, (j - i + 1) * height);
            }
        }
        return area;
    }
}
