package cn.eamon.leetcode001_100;

import java.util.HashMap;

/**
 * @Author: Eamon
 * @Description: 两数之和
 * @Date: 2020/12/1 19:45
 */
public class Num001TwoSum {
    /**
     * 方法一：
     *      哈希表 空间换时间
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 方法二：
     *      暴力法
     */
    public int[] twoSumVio(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("No found matched number!");
    }
}
