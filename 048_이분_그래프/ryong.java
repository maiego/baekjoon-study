import java.util.*;

class Main {
    // https://boj.kr/1707
    
    static List<Integer> adj[];
    static boolean fail;
    static int[] color;

    static void dfs(int u, int c) {
      if (color[u]==c) return;
      else if (color[u]==0) color[u] = c;
      else fail=true;
      if (fail) return;

      for (int v: adj[u]) {
        dfs(v, 3-c);
      }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-->0) {
          int n = sc.nextInt();
          int e = sc.nextInt();

          color = new int[n+1];
          
          adj = new List[n+1];
          for (int i=1; i<=n; ++i)
            adj[i] = new ArrayList<>();

          for (int i=0; i<e; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
          }

          fail = false;
          for (int i=1; i<=n; ++i)
            if (color[i]==0)
              dfs(i, 1);
          System.out.println(fail ? "NO" : "YES");
        }

    }
}