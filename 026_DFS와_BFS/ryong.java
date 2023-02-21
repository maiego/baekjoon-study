import java.util.*;

class Main {
    // https://boj.kr/1260

    static int n;
    static List<Integer> adj[];
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int u) {
      sb.append(u).append(' ');
      vis[u] = true;
      for (int v: adj[u]) {
        if (!vis[v])
          dfs(v);
      }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        vis = new boolean[n+1];
        adj = new List[n+1];
        for (int i=1; i<=n; ++i)
          adj[i] = new ArrayList<>();

        for (int i=0; i<m; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          adj[a].add(b);
          adj[b].add(a);
        }

        for (int i=1; i<=n; ++i)
          Collections.sort(adj[i]);

        dfs(start);
        sb.append('\n');

        Arrays.fill(vis, false);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start); vis[start] = true;
        while (!q.isEmpty()) {
          int u = q.poll();
          sb.append(u).append(' ');
          for (int v: adj[u]) {
            if (vis[v]) continue;
            vis[v] = true;
            q.add(v);
          }
        }

        System.out.println(sb);
    }
}

