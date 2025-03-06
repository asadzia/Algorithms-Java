/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
*/

class Solution {
    public String reverseWords(String s) {
        
        // Trim leading and trailing spaces
        String x = s.trim();

        // The algorithm is as follows:
        // - Reverse the entire string
        // - Reverse individual words in the next loop

        char[] arr = x.toCharArray();
        int i = 0, j = arr.length - 1;

        // Reverse the entire string
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }

        // Reverse each word in the string
        i = 0;
        while (i < arr.length) {

            int countSpaces = 0;

            // Skip spaces
            while (i < arr.length && arr[i] == ' ') {
                ++i;
            }

            // Find the end of the word
            j = i;
            while (j < arr.length && arr[j] != ' ') {
                ++j;
            }

            // Reverse the word
            int left = i, right = j - 1;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                ++left;
                --right;
            }

            // Move to the next word
            i = j;
        }

        // Convert the character array back to string and return
        return String.valueOf(arr);
    }
}
