import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class 스택_수열 {
  // https://boj.kr/1874

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i)
      arr[i] = sc.nextInt();

    Deque<Integer> stk = new ArrayDeque<>();
    boolean fail = false;
    int idx = 1;
    for (int i = 0; i < n; ++i) {
      while (idx <= arr[i]) {
        sb.append("+\n");
        stk.add(idx);
        ++idx;
      }

      while (!stk.isEmpty() && stk.peekLast() == arr[i]) {
        sb.append("-\n");
        stk.pollLast();
      }
    }

    if (!stk.isEmpty())
      System.out.println("NO");
    else
      System.out.println(sb);

  }
}
