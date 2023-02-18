import java.util.Arrays;
import java.util.Scanner;

class Main {
  // https://boj.kr/2751

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = sc.nextInt();

    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; ++i)
      arr[i] = sc.nextInt();

    Arrays.sort(arr);
    for (int x : arr)
      sb.append(x).append('\n');

    System.out.println(sb);

  }
}
