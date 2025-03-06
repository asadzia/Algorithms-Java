/*

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

  */

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // For this question, go with the following approach
        // Store the prefix sum in a hashmap for each index
        // check (sum - K) for each index to count the occurences of total number of subarrays
        // More explanation below
        // NOTE - if (prefix sum at index i - prefix sum at index j) = K then thats what we want and
        // is essneitally what we are doing in this algorithm but using (prefix sum at i - K = prefix sum at j) instead


        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // To handle the scenario where prefix sum index starts from the beginning of the array
        prefixSumCount.put(0, 1);

        int count = 0;
        int cur_sum = 0;

        for (int i = 0; i < nums.length; ++i) {

            cur_sum += nums[i];

            if (prefixSumCount.containsKey(cur_sum - k)) {

                // This is to handle the scenario of test cases like 
                // [1,-1,0]
                // where there are 3 subarrays
                // we need to keep track of count of subarrays created and then update accoridngly.
                count += prefixSumCount.getOrDefault(cur_sum - k, 1);
            }

            prefixSumCount.put(cur_sum, prefixSumCount.getOrDefault(cur_sum, 0) + 1);
        }
        return count;
    }
}
