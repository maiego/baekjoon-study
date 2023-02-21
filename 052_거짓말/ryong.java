import java.util.Scanner;

class Main {
    // https://boj.kr/1043
    static int[] link;

    static int find(int x) {
      while (x!=link[x]) {
        x = link[x] = link[link[x]];
      }
      return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        link = new int[n+1];
        for (int i=1; i<=n; ++i)
          link[i] = i;

        int knownN = sc.nextInt();
        int[] known = new int[knownN];
        for (int i=0; i<knownN; ++i) {
          known[i] = sc.nextInt();
        }
        for (int i=1; i<known.length; ++i) {
          int x=find(known[i-1]), y=find(known[i]);
          link[x] = y;
        }

        int[][] party = new int[m][];

        for (int j=0; j<m; ++j) {
          int cnt = sc.nextInt();
          party[j] = new int[cnt];
          for (int i=0; i<cnt; ++i)
            party[j][i] = sc.nextInt();
          for (int i=1; i<cnt; ++i) {
            int x=find(party[j][i-1]), y=find(party[j][i]);
            link[x] = y;
          }
        }

        int ans = 0;
        int g = knownN==0 ? 0 : find(known[0]);
        for (int i=0; i<m; ++i) {
          if (g != find(party[i][0]))
            ++ans;
        }

        System.out.println(ans);
    }
}