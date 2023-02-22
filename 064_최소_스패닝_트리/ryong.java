import java.util.*;

class Main {
    // https://boj.kr/1197

    static int[] link;

    static int find(int x) {
      while (x != link[x]) {
        x = link[x] = link[link[x]];
      }
      return x;
    }

    static class Item {
      int u,v, w;
      Item(int a, int b, int c) {
        u=a; v=b; w=c;
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        link = new int[n+1];
        for (int i=1; i<=n; ++i)
          link[i] = i;

        Item[] edges = new Item[m];

        for (int i=0; i<m; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          int c = sc.nextInt();

          edges[i] = new Item(a,b,c);

        }

        Arrays.sort(edges, (a,b)->a.w-b.w);
        
        int ans = 0;
        for (Item edge: edges) {
          int x=find(edge.u), y=find(edge.v);
          if (x==y) continue;
          ans += edge.w;
          link[x] = y;
        }
        System.out.println(ans);

    }
}