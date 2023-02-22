import java.util.*;

class Main {
    // https://boj.kr/1325

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> adj[] = new List[n+1];
        for (int i=1; i<=n; ++i)
          adj[i] = new ArrayList<>();

        for (int i=0; i<m; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          adj[b].add(a);
        }

        int[] cnt = new int[n+1];
        int maxCnt = 0;
        boolean[] vis;
        for (int i=1; i<=n; ++i) {
          vis = new boolean[n+1];
          Deque<Integer> q = new ArrayDeque<>();
          q.add(i); vis[i]=true;
          while (!q.isEmpty()) {
            int u = q.poll();
            ++cnt[i];
            for (int v: adj[u]) {
              if (vis[v]) continue;
              vis[v]=true;
              q.add(v);
            }
          }
          maxCnt = Math.max(maxCnt, cnt[i]);
        }

        for (int i=1; i<=n; ++i) {
          if (cnt[i]==maxCnt)
            System.out.print(i + " ");
        }

    }
}