import java.util.Scanner;

class Main {
    // https://boj.kr/1717

    static int[] link;

    static int find(int x) {
      while (x!=link[x]) {
        x = link[x] = link[link[x]];
      }
      return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        link = new int[n+1];
        for (int i=1; i<=n; ++i)
          link[i] = i;

        int q = sc.nextInt();
        while (q-->0) {
          int cmd = sc.nextInt();
          int a = sc.nextInt();
          int b = sc.nextInt();

          int x=find(a), y=find(b);
          if (cmd==0) {
            link[x] = y;
          } else {
            sb.append(x==y ? "YES\n" : "NO\n");
          }
        }
        System.out.println(sb);

    }
}

