package cn.lee983.Apple;

/**
 * @author: liweifeng
 * Date: 2020/02/24 15:39
 * @description: 最大子序和
 **/
public class LC0053MaximumSumSubarray {

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            max = Math.max(max, temp);
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{-2,1};
        System.out.println(LC0053MaximumSumSubarray.maxSubArray(nums));
    }
}
