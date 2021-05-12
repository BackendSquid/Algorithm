// https://www.acmicpc.net/problem/2609

import java.util.*;
import java.io.*;

public class Main {
  public static int gcd(int num1, int num2) {
    int a, b, r;
    if (num1 > num2) {
      a = num1;
      b = num2;
    } else {
      a = num2;
      b = num1;
    }

    while (a % b != 0) {
      r = a % b;
      a = b;
      b = r;
    }
    return b;
  }

  public static int lcm(int num1, int num2) {
    return num1 * num2 / gcd(num1, num2);
  }

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String args[]) throws IOException {
    String[] nums = br.readLine().split(" ");
    int a = Integer.parseInt(nums[0]);
    int b = Integer.parseInt(nums[1]);
    System.out.println(gcd(a, b));
    System.out.println(lcm(a, b));
  }
}
