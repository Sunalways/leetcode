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

    /**
     * 前缀和 + 暴力
     * @param nums
     * @return
     */
    public int maxSubArrayPrefixSum(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return sum;
    }

    /**
     * 优化前缀和
     * @param nums
     * @return
     */
    public int maxSubArrayPrefixSumBetter(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        int minSum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return maxSum;
    }

    public int maxSubArrayDividConquer(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        int mid = (l + r) >>> 1;
        int left = helper(nums, l, mid - 1);
        int right = helper(nums, mid + 1, r);
        int leftMaxSum = 0;
        int sum = 0;
        for (int i = mid - 1; i >= l; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }
        int rightMaxSum = 0;
        sum = 0;
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(sum, rightMaxSum);
        }
        return Math.max(leftMaxSum + rightMaxSum + nums[mid], Math.max(left, right));
    }

    public int maxSubArrayDp(int[] nums) {
        int currMaxSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = new int[]{-2,1};
        System.out.println(LC0053MaximumSumSubarray.maxSubArray(nums));
        LC0053MaximumSumSubarray main = new LC0053MaximumSumSubarray();
        System.out.println(main.maxSubArrayDividConquer(nums));
        System.out.println(main.maxSubArrayDp(nums));
    }
}
