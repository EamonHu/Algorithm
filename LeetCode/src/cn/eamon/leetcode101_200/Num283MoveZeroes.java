package cn.eamon.leetcode101_200;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/23 15:52
 */
public class Num283MoveZeroes {

    /**
     * 双指针
     * 跳过为0的数，将后面第一个不为0的数和0进行交换
     * i记录0的个数
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                i++;
            } else if (i != 0) {
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    /**
     * 将所有的非0数移到前面，后面补0
     * index相当于“新数组(结果数组)”的实际下标
     */
    public void moveZeroes2(int[] nums) {
        int index = 0;
        // 将所有非0移到前面来
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // 后面补0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 第二遍写
     */
    public void moveZeros3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public void moveZero4(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index++;
            } else if (index > 0) {
                nums[i - index] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
