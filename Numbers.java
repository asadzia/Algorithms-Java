import java.util.*;
import java.io.*;

class Main {

  public static void Algorithm(int value) {

    int start = 'A';
    int totalAlphabets = 26;
    int rem = 0;

    int num = value;
    StringBuilder sb = new StringBuilder();

    while(num > 0) {

      rem = num % totalAlphabets;

      if (rem == 0) {
        sb.append("Z");
        num = num / totalAlphabets - 1;
      } else {
        sb.append(((char)(start - 1 + rem)));
        num = num / totalAlphabets;
      }
    }

    System.out.println(sb.reverse());
  }

  public static void main (String args[]) {
    Algorithm(705);
  }
}
