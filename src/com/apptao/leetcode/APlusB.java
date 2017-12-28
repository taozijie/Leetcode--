package com.apptao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 2017-12-25.
 */
public class APlusB {


    public static void main(String args[]){
        System.out.println("aplusb" + "----------------------------------------------");
        int aplusb = aplusb(3, 5);
        System.out.println(aplusb + "");

        System.out.println("twoSum" + "----------------------------------------------");
        int[] twoSum = twoSum(new int[]{2, 3, 5, 7, 11, 12, 15}, 20);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }
    }

    /** aplusb 不用运算符+ commit
     * @param a
     * @param b
     * @return
     */
    private static int aplusb(int a, int b) {

        while (b!=0) {
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            a = tempA;
            b = tempB;

        }
        return a;
    }


    /**
     * 给定数组，给定目标，计算数组中有没有相加的和为目标值；
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //map 存放 运算值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i ++) {
            //反向计算获取 数组中的值
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);

        }

        throw new IllegalArgumentException("no two sum solution");


    }


}
