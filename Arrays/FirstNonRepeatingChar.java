import java.util.*;
import java.io.*;

class Main {

  public static void findNonRepeating (String str) {

    HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
    
    for (Character x : str.toCharArray()) {
      if (mp.get(x) == null) {
        mp.put(x, 1);
      } else {
        int count = mp.get(x);
        count++;
        mp.put(x, count);
      }
    }

    for (int i = 0; i < str.length(); ++i) {
      int count = mp.get(str.charAt(i));

      if (count == 1) {
        System.out.print(str.charAt(i));
        return;
      }
    }
  }

  public static void main(String[] args) {
      String str = "geeksforgeeks"; 
      findNonRepeating(str); 
  }
}
