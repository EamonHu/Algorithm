package cn.eamon.leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 15:05
 */
public class Num015ThreeSum {
    /**
     * 先排序，再夹逼
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[left] + nums[right] + nums[i];
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去除重复值
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return res;
    }
}
