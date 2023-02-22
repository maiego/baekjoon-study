import java.util.*;

class Main {
    // https://boj.kr/17472

    static int h,w;
    static int[][] board;

    static int[] link;
    static int find(int x) {
      while (x != link[x]) {
        x = link[x] = link[link[x]];
      }
      return x;
    }

    final static int[] dy={-1,1,0,0};
    final static int[] dx={0,0,-1,1};

    static boolean inRange(int y, int x) {
      return y>=0 && x>=0 && y<h && x<w;
    }

    static void dfs(int y, int x, int c) {
      board[y][x] = c;
      for (int d=0; d<4; ++d) {
        int ny = y + dy[d];
        int nx = x + dx[d];

        if (inRange(ny,nx) && board[ny][nx]==1)
          dfs(ny,nx,c);
      }
    }

    static class Edge {
      int u,v,w;
      Edge(int a, int b, int c) {
        u=a; v=b; w=c;
      }
    }

    static class Item {
      int y,x,dir,cnt,start;
      Item (int y, int x, int dir, int cnt, int start) {
        this.y=y; this.x=x; this.dir=dir;
        this.cnt=cnt; this.start=start;
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        board = new int[h][w];

        for (int i=0; i<h; ++i)
        for (int j=0; j<w; ++j)
          board[i][j] = sc.nextInt();

        // 섬 색칠하기
        int color = 2;
        for (int i=0; i<h; ++i)
        for (int j=0; j<w; ++j)
          if (board[i][j]==1)
            dfs(i,j, color++);

        link = new int[color];
        for (int i=2; i<color; ++i)
          link[i] = i;

        // 모든 다리 구하기
        List<Edge> edges = new ArrayList<>();
        Deque<Item> q = new ArrayDeque<>();
        for (int i=0; i<h; ++i)
        for (int j=0; j<w; ++j)
          if (board[i][j]!=0) {
            for (int d=0; d<4; ++d) {
              int ni=i+dy[d], nj=j+dx[d];
              if (inRange(ni, nj) && board[ni][nj]==0)
                q.add(new Item(i,j,d,0, board[i][j]));
            }
          }

        while (!q.isEmpty()) {
          Item item = q.poll();
          int y=item.y, x=item.x, dir=item.dir, cnt=item.cnt, start=item.start;

          int ny=y+dy[dir], nx=x+dx[dir];
          if (!inRange(ny,nx)) continue;
          if (board[ny][nx]==0)
            q.add(new Item(ny,nx, dir,cnt+1,start));
          else if (board[ny][nx]!=start && cnt!=1)
            edges.add(new Edge(start, board[ny][nx], cnt));
        }

        // 최소신장트리 비용 구하기
        edges.sort((a,b)->a.w-b.w);

        int ans=0, cnt=0;
        for (Edge edge: edges) {
          int x=find(edge.u), y=find(edge.v);
          if (x==y) continue;
          ans += edge.w;
          link[x] = y;
          if (++cnt == color-3) break;;
        }

        System.out.println(cnt==color-3 ? ans : -1);
    }
}