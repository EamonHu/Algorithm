package cn.eamon.leetcode001_100;

import cn.eamon.utils.PrintUtils;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/28 15:56
 */
public class Num066PlusOne {
    /**
     *方法一
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     *方法二
     */
    public static int[] plusOne2(int[] digits) {
        // 原数组转换成数字
        int len = digits.length - 1;
        long num = 0;
        for (int i = 0; i <= len; i++) {
            num += digits[i]*Math.pow(10,len-i);
        }
        num += 1;
        long temp = num;
        // 数字转换成新数组
        int count = 0;
        while(temp != 0){
            temp /= 10;
            count++;
        }
        int[] res = new int[count];
        for(int i = count - 1; i >= 0; i--) {
            res[i] = (int)(num % 10);
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = plusOne2(new int[]{9,8,7,6,5,4,3,2,1,0});
        PrintUtils.printArray(res);
    }
}
