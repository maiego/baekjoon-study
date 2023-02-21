import java.util.Scanner;

class Main {
    // https://boj.kr/11047

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; ++i)
          arr[i] = sc.nextInt();

        int ans = 0;
        for (int i=n-1; i>=0; --i) {
          if (k<arr[i]) continue;
          int cnt = k/arr[i];
          ans += cnt;
          k -= cnt*arr[i];
        }

        System.out.println(ans);
    }
}