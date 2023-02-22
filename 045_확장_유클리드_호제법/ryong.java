import java.util.Scanner;

class Main {
    // https://boj.kr/21568

    // a*m + b*n = g
    // (a/b*b + a%b)*m + b*n = g
    // b*x + a%b*y = g;
    // y = m, x = a/b*m + n
    // m = y, n = x - a/b*y
    static long g,m,n;
    static void euc(long a, long b) {
      if (b==0) {
        m=1; n=0; g=a;
        return;
      }
      euc(b, a%b);
      long x=m, y=n;
      m = y;
      n = x - a/b*y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        euc(a,b);

        if (c%g!=0) {
          System.out.println(-1);
        } else {
          long k = c/g;
          System.out.println(k*m + " " + k*n);
        }

    }
}

