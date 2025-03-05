/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        // Sort the input intervals based on the first element
        // Merge intervals by comparing the first and second elements

        int n = intervals.length;

        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));

        List<List<Integer>> resultList = new ArrayList<>();

        // start from the 2nd interval (if it exists) and initialize start and end of first interval
        int start = 0, end = 0;

        if (intervals != null && intervals[0] != null) {
            start = intervals[0][0];
            end = intervals[0][1];
        } else {
            return intervals;
        }

        for (int i = 1; i < n; ++i) {

            // candidate for merging intervals
            if (end >= intervals[i][0]) {
                
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            
                // check if further intervals can be merged so keep looping to next interval
                continue;
            } else {

                // add interval to array
                List<Integer> results = new ArrayList<>();
                results.add(start);
                results.add(end);
                resultList.add(results);

                // initialize start and end variables
                start = intervals[i][0];
                end = intervals[i][1];
                }
            }

        // To handle the final part of the loop
        List<Integer> results = new ArrayList<>();
        results.add(start);
        results.add(end);
        resultList.add(results);

        // Output a double array as required by the function signature
        int[][] resultsArr = new int[resultList.size()][2];
        int countResultsArr = 0;
        
        for (List<Integer> x : resultList) {
            int[] resultInterval = new int[] {x.get(0), x.get(1)};
            resultsArr[countResultsArr] = resultInterval;
            countResultsArr++;
        }


        return resultsArr;
    }
}
