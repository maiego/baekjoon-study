import java.util.Scanner;

class Main {
    // https://boj.kr/1976
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
        link = new int[n+1];
        for (int i=1; i<=n; ++i)
          link[i] = i;
        int m = sc.nextInt();
        for (int i=1; i<=n; ++i)
        for (int j=1; j<=n; ++j)
          if (sc.nextInt()==1) {
            int x=find(i), y=find(j);
            link[x] = y;
          }

        int[] arr = new int[m];
        for (int i=0; i<m; ++i)
          arr[i] = sc.nextInt();

        boolean fail = false;
        int g = find(arr[0]);
        for (int x: arr) {
          if (find(x)!=g)
            fail = true;
        }
        System.out.println(fail ? "NO" : "YES");
    }
}