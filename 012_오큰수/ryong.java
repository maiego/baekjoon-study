import java.util.*;

class 오큰수 {
  // https://boj.kr/17298

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; ++i)
      arr[i] = sc.nextInt();

    int[] ans = new int[n];
    Deque<Integer> stk = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; --i) {
      while (!stk.isEmpty() && arr[i] >= stk.peek())
        stk.pop();
      ans[i] = stk.isEmpty() ? -1 : stk.peek();
      stk.push(arr[i]);
    }

    for (int x : ans)
      sb.append(x + " ");
    System.out.println(sb);

  }
}
