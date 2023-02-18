import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class 연결_요소의_개수 {
    // https://boj.kr/11724

    static int n,m;
    static List<Integer> adj[];
    static boolean[] vis;

    static void dfs(int u) {
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
        m = sc.nextInt();

        vis = new boolean[n+1];

        adj = new List[n+1];
        for (int i=1; i<=n; ++i)
          adj[i] = new ArrayList<Integer>();

        for (int i=0; i<m; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          adj[a].add(b);
          adj[b].add(a);
        }

        int cnt=0;
        for (int i=1; i<=n; ++i) {
          if (!vis[i]) {
            ++cnt;
            dfs(i);
          }
        }

        System.out.println(cnt);

    }
}

