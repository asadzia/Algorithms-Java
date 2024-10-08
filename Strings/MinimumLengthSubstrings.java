/*
Minimum Length Substrings

You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.

Signature
int minLengthSubstring(String s, String t)

Input
s and t are non-empty strings that contain less than 1,000,000 characters each

Output
Return the minimum length of the substring of s. If it is not possible, return -1

Example
s = "dcbefebce"
t = "fd"
output = 5

Explanation:
Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
*/

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  int minLengthSubstring(String s, String t) {
    // Write your code here
    
    Map<Character, Integer> mp = new HashMap<Character, Integer>();
    
    for (char c : t.toCharArray()) {
      
      mp.put(c, mp.getOrDefault(c, 0) + 1);
    }
    
    char[] x = s.toCharArray();
    int len = 0;
    int lenOfCharsLeft = t.length();
    
    for (int i = 0; i < s.length(); ++i) {
      
      if (lenOfCharsLeft == 0) {
        break;
      }
      
      // Count the current Char
      len++;
      
      // Get the value of char from map if it exists.
      Integer val = mp.getOrDefault(x[i],0);
      
      if (val == 0) {
        continue;
      } 
      else {
        val--;
        lenOfCharsLeft--;
        mp.put(x[i], val);
      }
    } 
    
    if (lenOfCharsLeft != 0) {
      return -1;
    }
    
    return len;
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}
