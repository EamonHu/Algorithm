package cn.eamon.leetcode101_200;

import cn.eamon.utils.PrintUtils;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/25 17:38
 */
public class Num189Rotate {

    /**
     * 解法四：
     *      环状替代
     *      count用来表示置换的次数，数组中每个数字都会移位，count用来终止循环
     */
    public static void rotate4(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        for(int i = 0; count < len; i++) {
            int cur = i;
            do {
                int next = (cur + k) % len;
                swap(nums, i, next);
                cur = next;
                count++;
            } while (i != cur);
        }
        PrintUtils.printArray(nums);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    /**解法三
     * 三次反转：
     *      原数组 ：1234567
     *      一次反转：7654321
     *      二次反转：5674321
     *      三次反转：5671234
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }

    public void reverseArr(int[] nums, int start, int end) {
        int temp = 0;
        while( start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    /**
     * 解法二：
     *      依次移动，空间消耗少，空间复杂度高
     */
    public void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            moveLastEle(nums);
        }
    }

    /**
     * 最后一位元素移动到第一位，其他元素依次往后移动
     */
    public void moveLastEle(int[] nums){
        int len = nums.length;
        int temp =  nums[len - 1];
        for(int i = len-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = temp;
    }


    /**解法一：
     *      切割拼接 空间复杂度比较高
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[nums.length - k];
        System.arraycopy(nums, 0, arr, 0, nums.length - k);
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            nums[index++] = nums[i];
        }
        int i = 0;
        while (index < nums.length) {
            nums[index++] = arr[i++];
        }
        PrintUtils.printArray(nums);
    }

    public static void main(String[] args) {
        rotate4(new int[]{1, 2, 3, 4, 5, 6}, 4);
    }
}
