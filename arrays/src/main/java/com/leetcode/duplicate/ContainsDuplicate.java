package com.leetcode.duplicate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * Constraints:
 *     1 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 */
public class ContainsDuplicate {

    public boolean containsDuplicateUsingMap(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums)
                .forEach(num -> frequencyMap.compute(num, (k, v) -> frequencyMap.getOrDefault(num,0)+1));
        return frequencyMap.entrySet()
                .stream()
                .anyMatch(e -> e.getValue() > 1);
    }

    public boolean containsDuplicateUsingSet(int[] nums) {
        Set<Integer> distinct = Arrays.stream(nums)
                                    .boxed()
                                    .collect(Collectors.toSet());
        return distinct.size() < nums.length;

    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicateUsingMap(IntStream.of(1,2,3,4,1).toArray()));
        System.out.println(cd.containsDuplicateUsingSet(IntStream.of(1,2,3,4,1).toArray()));
    }

}
