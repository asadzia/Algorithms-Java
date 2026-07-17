/*
You are given a 2D string array A of dimensions N x 2,

where each row consists of two strings: first is the name of the student, second is their marks.

You have to find the maximum average mark. If it is a floating point, round it down to the nearest integer less than or equal to the number.



Problem Constraints
1 <= N <= 105


Input Format
The first argument is a 2D string array A.


Output Format
Return a single integer which is the highest average mark.


Example Input
Input 1:
A = [["Bob", "80"], ["Bob", "90"], ["Alice", "90"]]
Input 2:

A = [["Bob", "80"], ["Bob", "90"], ["Alice", "90"], ["Alice", "10"]]


Example Output
Output 1:
90
Output 2:

85
  */

public class Solution {
    public int highestScore(String[][] A) {
        
        Map<String, ArrayList<Integer>> mp = new HashMap<>();
        int max = 0;
        
        for (String[] score : A) {
            
            ArrayList<Integer> values = mp.getOrDefault(score[0], new ArrayList<>());
            values.add(Integer.parseInt(score[1]));
            mp.put(score[0], values);
        } 
        
        // now calculate average
        for (ArrayList<Integer> values : mp.values()) {
            double sum = 0;
            for (Integer val : values) {
                
                sum += val;
            }
            int cur_sum = (int)Math.floor(sum / values.size());
            
            if (cur_sum > max) {
                max = cur_sum;
            }
        }
        
        return max;
    }
}
