import java.util.*;

class Main {
    // https://boj.kr/1414

    static int[] link;
    
    static int find(int x) {
      while (link[x] != x) {
        x = link[x] = link[link[x]];
      }
      return x;
    }

    static int f(char c) {
      if ('a'<=c && c<='z')
        return c-'a'+1;
      return c-'A'+27;
    }

    static class Item {
      int u,v,w;
      Item(int a, int b, int c) {
        u=a; v=b; w=c;
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        link = new int[n];
        for (int i=0; i<n; ++i)
          link[i] = i;


        char[][] input = new char[n][];
        for (int i=0; i<n; ++i) {
          input[i] = sc.next().toCharArray();
        }

        List<Item> edges = new ArrayList<>();

        for (int i=0; i<n; ++i) {
          for (int j=0; j<n; ++j) {
            if (input[i][j]=='0') continue;
            edges.add(new Item(i,j, f(input[i][j])));
          }
        }

        edges.sort((a,b)->a.w-b.w);

        int cost=0;
        for (Item edge: edges) {
          int x=find(edge.u), y=find(edge.v);
          if (x==y) {
            cost += edge.w;
            continue;
          }
          link[x] = y;
        }

        boolean allConnected = true;
        for (int i=0; i+1<n; ++i)
          if (find(i)!=find(i+1))
            allConnected = false;

        System.out.println(allConnected ? cost: -1);

    }
}