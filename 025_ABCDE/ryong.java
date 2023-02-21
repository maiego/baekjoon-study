import java.util.*;

class Main {
    // https://boj.kr/13023
    
    static int n,e;
    static List<Integer> adj[];
    static boolean[] vis;
    static boolean done;

    static void dfs(int u, int k) {
      if (k>=5) done=true;
      if (done) return;
      for (int v: adj[u]) {
        if (vis[v]) continue;
        vis[v] = true;
        dfs(v, k+1);
        vis[v] = false;
      }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        e = sc.nextInt();

        adj = new List[n+1];
        for (int i=0; i<=n; ++i)
          adj[i] = new ArrayList<>();

        for (int i=0; i<e; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();

          adj[a].add(b);
          adj[b].add(a);
        }

        vis = new boolean[n];
        for (int i=0; i<n; ++i) {
          vis[i] = true;
          dfs(i, 1);
          vis[i] = false;
        }

        System.out.println(done ? 1 : 0);
    }
}