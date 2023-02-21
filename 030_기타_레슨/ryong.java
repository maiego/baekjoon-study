import java.util.Scanner;

class Main {
    // https://boj.kr/2343

    static int n,k;
    static int[] arr;

    static boolean check(int size) {
      int acc=0, cnt=1;
      for (int x: arr) {
        if (x>size) return false;
        if (acc+x<=size)
          acc+=x;
        else {
          acc = x;
          ++cnt;
        }
      }
      return cnt<=k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n];
        for (int i=0; i<n; ++i)
          arr[i] = sc.nextInt();

        int lo=0, hi=(int)1e9;
        while (hi-lo > 1) {
          int mid = (lo+hi)/2;
          if (check(mid))
            hi=mid;
          else lo=mid;
        }
        System.out.println(hi);

    }
}