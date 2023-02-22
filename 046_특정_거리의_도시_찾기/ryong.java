import java.util.*;

class Main {
    // https://boj.kr/18352

    static List<Integer> adj[];

    static class Item {
      int u, cnt;
      Item(int a, int b) {
        u=a; cnt=b;
      }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int start = sc.nextInt();

        adj = new List[n+1];
        for (int i=1; i<=n; ++i)
          adj[i] = new ArrayList<>();
        
        for (int i=0; i<m; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          adj[a].add(b);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;

        Deque<Item> q = new ArrayDeque<>();
        q.add(new Item(start, 0));
        while (!q.isEmpty()) {
          Item item = q.poll();
          int u=item.u, cnt=item.cnt;
          if (dist[u]<cnt) continue;
          for (int v: adj[u]) {
            if (dist[v]<=cnt+1) continue;
            dist[v] = cnt+1;
            q.add(new Item(v, cnt+1));
          }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=1; i<=n; ++i)
          if (dist[i] == k)
            ans.add(i);

        for (int x: ans)
          System.out.println(x);
        if (ans.isEmpty()) System.out.println(-1);
    }
}