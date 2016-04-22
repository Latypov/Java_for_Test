package my.javapr.sandbox;

import java.util.Scanner;

/**
 * Created by Nurulla on 4/17/2016.
 * https://www.hackerrank.com/challenges/summing-the-n-series
 */
public class Solution {
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    Scanner sc = new Scanner(System.in);
    int numOfTestCases = sc.nextInt();
    int T = 1;
    while (T<=numOfTestCases && sc.hasNextInt()) {

      long n = 1;
      long input = sc.nextInt();
      long Sum = 0;
      while (n<=input) {
        long seriesMemberN = n*n - (n-1)*(n-1);
        Sum = Sum + seriesMemberN;
        n++;
      }
      long result = Sum%100000007;
      System.out.println(result);
    }
    sc.close();
  }
}
