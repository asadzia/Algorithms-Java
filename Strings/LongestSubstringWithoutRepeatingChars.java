/*
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> mp = new HashMap<>();
        int lengthOfLongestSubStr = 0;
        int cur = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {

            int count = mp.getOrDefault(s.charAt(i), 0);

            if (count == 0) {
                mp.put(s.charAt(i), 1);
                cur++;
                continue;
            } else {

                // Update the longestSubStr length
                // We are using a sliding window to find long subString
                if (cur > lengthOfLongestSubStr) {
                    lengthOfLongestSubStr = cur;
                }

                while (l < i) {
                    if (s.charAt(l) != s.charAt(i)) {
                        mp.put(s.charAt(l), 0);
                        l++;
                        cur--;
                        continue;
                    } else {
                        l++;
                        mp.put(s.charAt(i), 1);
                        break;
                    }
                }
            }
        }

        // To handle the case where the entire string is non-repeating
        // OR when looping, we never go to the else condition and the loop exists.
        if (lengthOfLongestSubStr < cur) {
            lengthOfLongestSubStr = cur;
        }

        return lengthOfLongestSubStr;

    }
}
