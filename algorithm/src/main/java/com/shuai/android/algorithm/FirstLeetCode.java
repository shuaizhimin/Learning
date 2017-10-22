package com.shuai.android.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/22
 * Time:下午7:46
 */
public class FirstLeetCode {
    private static int[] nums = {2, 9, 13,15,16,18,19,22,23,25,26,27,34,35,36,37,38,41,42,43,44,45,46,47,56,58,59,7};

    public static void main(String args[]) {
        twoSumFirst(nums, 9);
        towSumSecond(nums, 9);

    }

    /**
     * 给定一个数组,查找两个数相加等于给定值
     *
     * @param nums
     * @param target
     * @return 时间复杂度O(n)
     */
    public static int[] twoSumFirst(int[] nums, int target) {
        long currentMillis=System.currentTimeMillis();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }
        }
        long endMillis=System.currentTimeMillis();
        System.out.println("twoSumFirst:" + Arrays.toString(result)+" 时间:"+(endMillis-currentMillis)+"ms");
        return result;
    }


    public static int[] towSumSecond(int[] nums, int target) {
        long currentMillis=System.currentTimeMillis();
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0;i<nums.length;i++){
            int key=target-nums[i];
            if(map.containsKey(key)&&map.get(key)!=i){
                result[0]=key;
                result[1]=nums[i];
            }
        }
        long endMillis=System.currentTimeMillis();
        System.out.println("towSumSecond:" + Arrays.toString(result)+" 时间:"+(endMillis-currentMillis)+"ms");
        return result;
    }
}
