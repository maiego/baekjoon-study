import java.util.*;

class Main {
    // https://boj.kr/2178
    static int h,w;

    static class Item {
      int y,x,cnt;
      Item(int a, int b, int c) {
        y=a; x=b; cnt=c;
      }
    }
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static boolean inRange(int y, int x) {
      return y>=0 && x>=0 && y<h && x<w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();

        char[][] board = new char[h][];
        for (int i=0; i<h; ++i)
          board[i] = sc.next().toCharArray();

        boolean[][] vis = new boolean[h][w];

        int ans = 0;
        Deque<Item> q = new ArrayDeque<>();
        q.add(new Item(0,0,1));
        while (!q.isEmpty()) {
          Item item = q.poll();
          int y = item.y;
          int x = item.x;
          int cnt = item.cnt;

          if (y==h-1 && x==w-1) {
            ans = cnt;
            break;
          }

          for (int d=0; d<4; ++d) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (inRange(ny,nx) && board[ny][nx]!='0' && !vis[ny][nx]) {
              vis[ny][nx] = true;
              q.add(new Item(ny,nx,cnt+1));
            }
          }
        }

        System.out.println(ans);
    }
}

