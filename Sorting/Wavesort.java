import java.util.*;
import java.io.*;

class Main {

  public static void WaveSort (int arr[]) {

    for (int i = 0; i < arr.length; i += 2) {

      if (i > 0 && arr[i - 1] > arr[i]) {
        int t = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = t;
      }

      if (i < arr.length - 1 && arr[i + 1] > arr[i]) {
        int t = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = t;
      }
    }

    for (int j = 0; j < arr.length; ++j) {
      System.out.print(arr[j] + " ");
    }
  }

  public static void main(String[] args) {
      int arr[] = {10, 90, 49, 2, 1, 5, 23}; 
      WaveSort(arr); 
  }
}
