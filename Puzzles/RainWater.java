/*

Problem Description

Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is integer array A.



Output Format
Return the total water it is able to trap after raining.



Example Input
Input 1:

 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:

 A = [1, 2]


Example Output
Output 1:

 6
Output 2:

 0


Example Explanation
Explanation 1:

 
 In this case, 6 units of rain water (blue section) are being trapped.
Explanation 2:

 No water is trapped.

  */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        
        // Algorithm:
        // Two pointers - left and right
        // if the right is higher than left, then add units of water (equal to heigh of left) since 
        // water cannot rise above the height of left (despite right being taller)
        // and vice versa
        
        int left = 1;
        int right = A.size() - 2;
        int result = 0;
        
        int leftMax = A.get(left - 1);
        int rightMax = A.get(right + 1);
        
        while (left <= right) {
            
            if (leftMax <= rightMax) {
                
                result += Math.max(0, leftMax - A.get(left));
                leftMax = Math.max(leftMax, A.get(left));
                left++;
                
            } else {
                
                result += Math.max(0, rightMax - A.get(right));
                rightMax = Math.max(rightMax, A.get(right));
                right--;
            }
        }
        
        return result;
    }
}
