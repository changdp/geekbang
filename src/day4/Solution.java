package day4;

import java.util.Arrays;

/**
 * day 4 home work leetcode 88
 *
 *88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author changdp
 * @create 2020-03-11 11:49
 **/
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums_result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {

            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                nums_result[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            nums_result[k] = nums2[j];
            j++;
            k++;

        }
        System.arraycopy(nums_result, 0, nums1, 0, m + n);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        solution.merge2(a, 3, b, 3);

    }

}
