package cn.eamon.leetcode001_100;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/30 17:26
 */
public class Num084LargestRectangleArea {

    /**
     * 方法二：
     *      暴力法优化：O(n^2)
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
     *      暴力法：O(n^3) 不通过
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
