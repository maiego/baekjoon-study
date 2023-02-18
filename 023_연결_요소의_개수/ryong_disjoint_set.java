import java.util.Scanner;

class 연결_요소의_개수 {
    // https://boj.kr/11724

    static int n,m;
    static int[] link;

    static int find(int x) {
      while (x!=link[x]) {
        x = link[x] = link[link[x]];
      }
      return x;
    }
    // static int find(int x) {
    //   return x==link[x] ? x : (link[x] = find(link[x]));
    // }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        link = new int[n+1];
        for (int i=1; i<=n; ++i)
          link[i] = i;

        for (int i=0; i<m; ++i) {
          int a = sc.nextInt();
          int b = sc.nextInt();

          int x=find(a), y=find(b);
          if (x!=y) link[x] = y;
        }

        int cnt=0;
        for (int i=1; i<=n; ++i)
          if (i==link[i])
            ++cnt;

        System.out.println(cnt);

    }
}

