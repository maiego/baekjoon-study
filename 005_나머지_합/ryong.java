import java.util.Scanner;

class Main {
    // https://boj.kr/10986
    static int n,m;
    static int[] arr, pref;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        pref = new int[n+1];

        // n<=1e6 이기 때문에 n*n 은 int 오버플로우가 일어날 수 있다.
        long ans = 0;

        // 이전에 같은 누적합의 값이 몇번 나왔는지 기록한다.
        int[] cnt = new int[m];
        cnt[0] = 1;
        for (int i=0; i<n; ++i) {
          arr[i] = sc.nextInt()%m;
          pref[i+1] = (pref[i]+arr[i])%m;
          ans += cnt[pref[i+1]];
          cnt[pref[i+1]]++;
        }

        System.out.println(ans);

    }
}

