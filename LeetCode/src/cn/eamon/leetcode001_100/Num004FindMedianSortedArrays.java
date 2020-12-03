package cn.eamon.leetcode001_100;

/**
 * @Author: Eamon
 * @Description: 寻找两个有序数组的中位数
 * @Date: 2020/12/2 16:00
 */
public class Num004FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSorted(nums1, nums2));
        System.out.println(findMedianSort(nums1, nums2));
    }

    // 二分查找，每次排除一半小于中位数
    public static double findMedianSort(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = n + m;
        return (helper(nums1, 0, m, nums2, 0, n, (len + 1) / 2) + helper(nums1, 0, m, nums2, 0, n, (len + 2) / 2)) / 2.0;
    }

    private static double helper(int[] nums1, int aStart, int aEnd, int[] nums2, int bStart, int bEnd, int k) {
        int len1 = aEnd - aStart + 1;
        int len2 = bEnd - bStart + 1;
        // 保证上面先为空
        if (len1 > len2) {
            return helper(nums2, bStart, bEnd, nums1, aStart, aEnd, k);
        }
        if (len1 == 0) {
            return nums2[bStart + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[aStart], nums2[bStart]);
        }

        int i = aStart + Math.min(len1, k / 2) - 1;
        int j = bStart + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return helper(nums1, aStart, aEnd, nums2, j + 1, bEnd, k - (j - bStart + 1));
        } else {
            return helper(nums1, i + 1, aEnd, nums2, bStart, bEnd, k - (i - aStart + 1));
        }
    }

    /**
     * 在合并数组的基础上优化，无需合并整个数组，只需要找到中位数就行了
     */
    public static double findMedianSorted(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int aStart = 0, bStart = 0;
        // 两个变量存储两个/一个中位数
        int right = -1, left = -1;

        for (int i = 0; i <= len / 2; i++) {
            left = right;
            // 数组1后移的条件：
            //      1.数组1没有越界
            //      2.数组1对应位置小于数组2 或者 数组2已经指向空了
            if ((aStart < m) && (bStart >= n || nums1[aStart] <= nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    // 合并两个数组
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        // 数组1为空的情况
        if (m == 0) {
            if ((n & 1) == 1) {
                return nums2[n / 2];
            } else {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }
        }

        // 数组2位空的情况
        if (n == 0) {
            if ((m & 1) == 1) {
                return nums1[m / 2];
            } else {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            }
        }

        int count = 0;
        int i = 0, j = 0;
        // 归并排序
        while (count != m + n) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        // 奇偶判断
        if ((count & 1) == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
}
