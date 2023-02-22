import java.util.*;

class Main {
    // https://boj.kr/1068

    static List<Integer> adj[];
    static int[] leafCnt;

    static void dfs(int u, int p) {
      int childCnt = 0;
      for (int v: adj[u]) {
        if (v==p) continue;
        ++childCnt;
        dfs(v, u);
        leafCnt[u] += leafCnt[v];
      }
      if (childCnt==0) leafCnt[u] = 1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        leafCnt = new int[n];
        int[] par = new int[n];
        adj = new List[n];
        for (int i=0; i<n; ++i)
          adj[i] = new ArrayList<>();

        int root = 0;
        for (int i=0; i<n; ++i) {
          int p = sc.nextInt();
          par[i] = p;
          if (p==-1) root=i;
          else adj[p].add(i);
        }

        int node = sc.nextInt();

        dfs(root, -1);
        int ans = leafCnt[root] - leafCnt[node];
        if (node!=root && adj[par[node]].size()==1)
          ++ans;

        System.out.println(ans);

    }
}