import java.util.*;

class Main {
    // https://boj.kr/11725

    static List<Integer> adj[];
    static int[] par;

    static void dfs(int u, int p) {
      par[u] = p;
      for (int v: adj[u]) {
        if (v==p) continue;
        dfs(v,u);
      }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        par = new int[n+1];
        adj = new List[n+1];
        for (int i=1; i<=n; ++i)
          adj[i] = new ArrayList<>();

        for (int i=0; i<n-1; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();

          adj[a].add(b);
          adj[b].add(a);
        }

        dfs(1,-1);

        for (int i=2; i<=n; ++i)
          System.out.println(par[i]);

    }
}