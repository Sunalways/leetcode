package cn.lee983.Apple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 62458
 * @Date: 2020/4/26 21:48
 * @Description:
 *  Given an integer array arr and an integer difference,
 *  return the length of the longest subsequence in arr
 *  which is an arithmetic sequence such that the
 *  difference between adjacent elements in the subsequence equals difference.
 *
 *  Input: arr = [1,2,3,4], difference = 1
 *  Output: 4
 *  Explanation: The longest arithmetic subsequence is [1,2,3,4].
 *
 *  Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 */
public class LC1218LongestSubsequenceOfDiff {

    /**
     * 此解法Time out 时间复杂度为 N平方
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequenceTimeOut(int[] arr, int difference) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int subLen = 1;
            int j = i + 1;
            int temp = arr[i];
            while (j < arr.length) {
                if (arr[j] == temp + difference) {
                    subLen++;
                    temp = arr[j];
                }
                j++;
            }
            max = Math.max(subLen, max);
        }
        return max;
    }

    /**
     * difference between -10^4 ~ 10^4
     * 使用map存储上一位i存的子序列长度。
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequenceDPAC(int[] arr, int difference) {
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i] - difference)) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i] - difference) + 1);
            }
            res = Math.max(res, map.get(arr[i]));
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//        int difference = 1;
//        int[] arr = {1, 3, 5, 7};
//        int difference = 1;
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = -2;
        int out = LC1218LongestSubsequenceOfDiff.longestSubsequenceDPAC(arr, difference);
        System.out.println(out);
    }
}
