package my.javapr.sandbox;

import java.util.Scanner;

/**
 * Created by Nurulla on 4/17/2016.
 * https://www.hackerrank.com/challenges/summing-the-n-series
 */
public class Solution {
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    Scanner scanner = new Scanner(System.in);
    int numberOfTestCases = scanner.nextInt();
    int T = 1;
    while (T<=numberOfTestCases && scanner.hasNextInt()) {

      long n = 1;
      long Sum = 0;
      long input = scanner.nextInt();
      while (n<=input) {
        long seriesMemberN = n*2 - 1;
        Sum = Sum + seriesMemberN;
        n++;
      }
      long result = Sum%100000007;
      System.out.println(result);
      }
    scanner.close();
  }
}
