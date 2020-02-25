package cn.lee983.Apple;

import java.util.Stack;

/**
 * @author: liweifeng
 * Date: 2020/02/24 14:48
 * @description: 删除排序数组中的重复项
 **/
public class LC0026RemoveDuplicatesFromSortedArray {

    /**
     * 一开始的思路是，使用了三个变量，没有比对到最后一个数组元素就退出。
     * 用storeIndex 存放当前的数组
     * 用compareIndex 存放要比对的数组
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int storeIndex = 0;
        for (int compareIndex = 0; compareIndex < nums.length; compareIndex++) {
            if (nums[compareIndex] != nums[storeIndex]) {
                storeIndex++;
                nums[storeIndex] = nums[compareIndex];
            }
        }
        return storeIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(LC0026RemoveDuplicatesFromSortedArray.removeDuplicates(nums));
    }
}
