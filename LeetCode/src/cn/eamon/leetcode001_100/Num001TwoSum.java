package cn.eamon.leetcode001_100;

import java.util.HashMap;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/1 19:45
 */
public class Num001TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
