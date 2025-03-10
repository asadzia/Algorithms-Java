/*
Given an integer array A consisting of distinct elements.

You are asked to create a lexicograhically largest array S = X + reverse(Y) ('+' denotes concatenation) such that it satisfies the following conditions:

len(S) <= len(A)
X is the prefix array of array A and Y is the suffix array of array A.
Note: Array X or Y can be empty.



Problem Constraints
1 <= len(A) <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A.



Output Format
Return an integer array denoting the lexicographically largest array S.



Example Input
Input 1:

 A = [4, 1, 3, 2]
Input 2:

 A = [10, 20, 30, 40]


Example Output
Output 1:

 [4, 2, 3, 1]
Output 2:

 [40, 30, 20, 10]


Example Explanation
Explanation 1:

 X = [4], Y = [1, 3, 2]. Reverse(Y) = [2, 3, 1]
 S = X + Reverse(Y) = [4, 2, 3, 1]
Explanation 2:

 X = [], Y = [10, 20, 30, 40]. Reverse(Y) = [40, 30, 20, 10]
 S = [40, 30, 20, 10]
*/



public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        
        int n = A.size();
        int l = 0;
        int r = n - 1;
        int i;
        
        for (i = 0; i < n; ++i) {
            if (A.get(i) < A.get(r)) {
                break;
            }
        }
        
        l = i;
        
        // Swap and reverse the elements of the suffix array
        while (l < r) {
            Integer x = A.get(l);
            A.set(l, A.get(r));
            A.set(r, x);
            l++;
            r--;
        }
        
        return A;
    }
}
