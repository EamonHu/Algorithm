package cn.eamon.leetcode001_100;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 14:09
 */
public class Num011MaxArea {

    /**
     * 暴力法
     * O(n^2)
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /**
     * 双指针法
     * O(n)
     */
    public int maxArea2(int[] height) {
        int max = 0;
        int j = height.length - 1, i = 0;
        while (i < j) {
            max = Math.max(max, getArea(i, j, height));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public int getArea(int i, int j, int[] height) {
        if (i > j) {
            return 0;
        }
        return (j - i) * Math.min(height[i], height[j]);
    }

    /**
     * 双指针代码简洁写法
     */
    public int maxArea3(int[] height) {
        int max = 0;
        int j = height.length - 1, i = 0;
        while (i < j) {
            max = height[i] < height[j] ? Math.max(max, (j - i) * height[i++]) : Math.max(max, (j - i) * height[j--]);
        }
        return max;
    }
}
