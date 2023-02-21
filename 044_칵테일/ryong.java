import java.util.*;

class Main {
    // https://boj.kr/1033

    static int gcd(int a, int b) {
      return b==0 ? a : gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int[][] input = new int[n][4];
        for (int i=0; i<n-1; ++i) {
          int a,b,c,d;
          a = sc.nextInt();
          b = sc.nextInt();
          c = sc.nextInt();
          d = sc.nextInt();
          int g = gcd(c,d);
          c/=g; d/=g;

          input[i][0] = a;
          input[i][1] = b;
          input[i][2] = c;
          input[i][3] = d;
        }

        int[] arr = new int[n]; //분자
        int[] brr = new int[n]; //분모

        arr[0] = 1;
        brr[0] = 1;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
          int x = q.poll();

          for (int i=0; i<n-1; ++i) {
            if (input[i][0] == x) {
              int y = input[i][1];
              if (brr[y]!=0) continue;
              int rx = input[i][2];
              int ry = input[i][3];
              int a = arr[x]*ry;
              int b = brr[x]*rx;
              int g = gcd(a,b);
              arr[y] = a/g;
              brr[y] = b/g;
              q.add(y);
            } else if (input[i][1] == x) {
              int y = input[i][0];
              if (brr[y]!=0) continue;
              int ry = input[i][2];
              int rx = input[i][3];
              int a = arr[x]*ry;
              int b = brr[x]*rx;
              int g = gcd(a,b);
              arr[y] = a/g;
              brr[y] = b/g;
              q.add(y);
            }
          }
        }

        int g = 1;
        for (int i=0; i<n; ++i)
          g = gcd(g, arr[i]);
        for (int i=0; i<n; ++i)
          arr[i] /= g;

        g = 1;
        for (int i=0; i<n; ++i)
          g = g/gcd(g, brr[i]) * brr[i];

        for (int i=0; i<n; ++i)
          System.out.print(g/brr[i]*arr[i] + " ");

    }
}