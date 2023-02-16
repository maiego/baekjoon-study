import java.io.*;
import java.util.*;

class 최솟값_찾기 {
  // https://boj.kr/11003

  static class Item {
    int value, idx;

    Item(int a, int b) {
      value = a;
      idx = b;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i)
      arr[i] = Integer.parseInt(st.nextToken());

    Deque<Item> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!q.isEmpty() && q.peekLast().value >= arr[i])
        q.pollLast();
      q.add(new Item(arr[i], i));

      while (q.peek().idx <= i - k)
        q.poll();

      sb.append(q.peek().value).append(" ");
    }

    System.out.println(sb);

  }
}
