package cn.eamon.leetcode001_100;

import java.util.Arrays;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/1 19:56
 */
public class SelfTest {

    public static void main(String[] args) {
        // 给定 nums = [2, 7, 11, 15], target = 9
        //因为 nums[0] + nums[1] = 2 + 7 = 9
        //所以返回 [0, 1]
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(Num001TwoSum.twoSum(nums, 9)));
    }
}
