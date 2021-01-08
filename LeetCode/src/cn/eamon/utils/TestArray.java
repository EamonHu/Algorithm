package cn.eamon.utils;

import java.util.Arrays;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/8 11:46
 */
public class TestArray {

    public static void main(String[] args) {
        int[] heights = new int[]{1, 2, 3};
        int len = heights.length;
        int area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;
        for (int height : heights) {
            System.out.println(height);
        }
    }
}
