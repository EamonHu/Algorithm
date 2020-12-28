package cn.eamon.leetcode001_100;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/25 17:15
 */
public class Num026RemoveDuplicates {
    /**
     * 双指针法
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index + 1;
    }
}
