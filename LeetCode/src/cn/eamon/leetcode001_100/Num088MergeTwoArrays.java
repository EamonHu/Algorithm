package cn.eamon.leetcode001_100;

import java.util.Arrays;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/28 15:19
 */
public class Num088MergeTwoArrays {

    /**
     * 方法二：
     *      调用已有API
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 方法一：
     *      归并排序（双指针）
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        System.arraycopy(nums1, 0, arr, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            nums1[k++] = arr[i] < nums2[j] ? arr[i++] : nums2[j++];
        }
        while( i < m) {
            nums1[k++] = arr[i++];
        }
        while( j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}
