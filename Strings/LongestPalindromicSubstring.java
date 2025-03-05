/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    public String longestPalindrome(String s) {

        // Solve this by using the center expansion algorithms
        // i.e start from a char in the string at position i
        // then check left and right of it to see its a palindrome
        // continue until its not.
        // Proceed with this process for all the chars of the string
        // Store the longest palindrome accordingly.
        
        int n = s.length();
        int max = 0;
        String longest = null;

        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < n; ++i) {

            // for an odd numbered palindrome
            String oddPalindrome = findSubstringPalindromeLength(s, i, i);
            if (oddPalindrome.length() > max) {
                max = oddPalindrome.length();
                longest = oddPalindrome;
            }

            // for an even numbered palindrome
            String evenPalindrome = findSubstringPalindromeLength(s, i, i + 1);
            if (evenPalindrome.length() > max) {
                max = evenPalindrome.length();
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    public String findSubstringPalindromeLength(String s, int left, int right) {

        // count is initially one for the individual character itself.
        int count;

        if (left == right) {
            // Odd palindrome so initially we at least have one character from where the search starts
            count = 1;
        } else {
            // Even palindrome so we start from between two chars in the string.
            count = 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count += 2;
        }
        return s.substring(left + 1, right);
    }
}
