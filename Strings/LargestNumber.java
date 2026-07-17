/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

*/

class Solution {
    public String largestNumber(int[] nums) {

        String[] numbers = new String[nums.length];
        
        // convert each integer to a string
        for (int i = 0; i < nums.length; ++i) {

            String val = Integer.toString(nums[i]);
            numbers[i] = val;
        }

        // Use comaprator and sort in descending order
        // each number is appended together and compared which is larger
        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

         // Handle scenario where largest number is 0
        if (numbers[0].equals("0")) {
            return "0";
        }

        // Now concatenate and return
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; ++i) {
            result.append(numbers[i]);
        }

        return result.toString();
    }
}
