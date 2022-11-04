package org.example.AddSums;

import java.util.*;

/**
 * @Author: LIVI
 * @Time: 2022/11/01  20:33
 * @Description:
 */
public class useHashmap {
    static Map<Integer, Integer> m = new HashMap<>();
    static Map map = new HashMap<>();

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int m[] = new int[] {(int) map.get(complement), i };
                return m;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        twoSum(nums, target);
        Set<Integer> key = map.keySet();
        Iterator<Integer> iterator = key.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer value = (Integer) map.get(next);
            System.out.println(key + ": " + value);
        }
    }

}
