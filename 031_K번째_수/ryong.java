import java.util.Scanner;

class Main {
    // https://boj.kr/1300

    static int n;
    static int k;

    static boolean check(long x) {
      long acc = 0;
      for (int i=1; i<=Math.min(n,x); ++i) {
        acc += Math.min(n,x/i);
      }
      return acc<k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        // n*n int 오버플로우
        long lo=0, hi=1L*n*n+1;
        while (hi-lo>1) {
          long mid = (lo+hi)/2;
          if (check(mid))
            lo=mid;
          else hi=mid;
        }
        System.out.println(hi);
    }
}