import java.util.*;

class Main {
    // https://boj.kr/1715

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int[] arr = new int[n];
        for (int i=0; i<n; ++i) {
          arr[i] = sc.nextInt();
          q.add(arr[i]);
        }

        int ans = 0;
        while (q.size()>1) {
          int a = q.poll();
          int b = q.poll();
          ans += a+b;
          q.add(a+b);
        }
        System.out.println(ans);
    }
}