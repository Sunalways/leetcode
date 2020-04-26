package cn.lee983.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 62458
 * @Date: 2020/2/26 20:07
 * @Description:
 */
public class LC0088MergeSortedArray {

    public void mergeForSort(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        while (cur >= 0) {
            if (n == 0) {
                return;
            }
            if (m < 1) {
                nums1[cur--] = nums2[--n];
                continue;
            }
            if (n < 1) {
                nums1[cur--] = nums1[--m];
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[cur--] = nums1[--m];
            } else {
                nums1[cur--] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {

    }
}
