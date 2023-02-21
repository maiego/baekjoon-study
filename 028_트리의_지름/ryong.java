import java.util.*;

class Main {
    // https://boj.kr/1167
    static int n;
    static List<Item> adj[];
    static int node, ans;

    static class Item {
      int v,w;
      Item(int a, int b) {
        v=a; w=b;
      }
    }

    static void dfs(int u, int p, int dist) {
      if (ans < dist) {
        node = u;
        ans = dist;
      }

      for (Item item: adj[u]) {
        int v=item.v, w=item.w;
        if (v==p) continue;
        dfs(v, u, dist+w);
      }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        adj = new List[n+1];
        for (int i=1; i<=n; ++i)
          adj[i] = new ArrayList<>();

        for (int i=0; i<n; ++i) {
          int u = sc.nextInt();
          int a,b;
          while (true) {
            a = sc.nextInt();
            if (a==-1) break;
            b = sc.nextInt();
            adj[u].add(new Item(a,b));
          }
        }

        dfs(1, -1, 0);
        dfs(node, -1, 0);
        
        System.out.println(ans);
    }
}