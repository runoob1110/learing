package com.letcode.simple;

/**
 * @author ：panleilei
 * @description  两数之和
 * @modified By：
 * @version:
 * @date ：Created in 2023/3/15 21:17
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TowNumSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = solution(nums,target);
        System.out.println(result);
    }

    private static int[] solution(int[] nums, int target) {
        int len = nums.length;
        // 哈希表
        Map<Integer,Integer> hashmap = new HashMap<>(len -1);
        hashmap.put(nums[0],0);
        for (int i = 1; i < len; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[]{hashmap.get(target - nums[i]),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }
}
















