import java.util.Scanner;

class 구간_합_구하기_5 {
    // https://boj.kr/11660
    static int n,m;
    static int[][] board, pref;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];
        pref = new int[n+1][n+1];

        for (int i=0; i<n; ++i) {
          for (int j=0; j<n; ++j) {
            board[i][j] = sc.nextInt();
            pref[i+1][j+1] = pref[i+1][j] + pref[i][j+1] - pref[i][j] + board[i][j];
          }
        }

        while (m-->0) {
          int sy = sc.nextInt()-1;
          int sx = sc.nextInt()-1;
          int ey = sc.nextInt();
          int ex = sc.nextInt();

          sb.append(pref[ey][ex] - pref[ey][sx] - pref[sy][ex] + pref[sy][sx]).append('\n');
        }

        System.out.println(sb);

    }
}
