/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> col = new Stack<>();

        for (Character c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                col.push(c);
            } else {
                // for closing brackets
                if (col.size() == 0) {
                    return false;
                }
                
                Character x = col.pop();

                if ((c == ')' && x == '(') || 
                (c == '}' && x == '{') ||
                (c == ']' && x == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (col.size() == 0) {
            return true;
        }
        return false;
    }
}
