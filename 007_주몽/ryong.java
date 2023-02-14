import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    // https://boj.kr/1940

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> cntMap = new HashMap<>();

        int[] arr = new int[n];
        for (int i=0; i<n; ++i) {
          arr[i] = sc.nextInt();
          int x = cntMap.getOrDefault(arr[i], 0);
          cntMap.put(arr[i], 1+x);
        }

        int ans = 0;
        for (int i=1; i<(m+1)/2; ++i) {
          int cnt1 = cntMap.getOrDefault(i, 0);
          int cnt2 = cntMap.getOrDefault(m-i, 0);

          ans += Math.min(cnt1, cnt2);
        }
        if (n==2) ans += cntMap.getOrDefault(n/2, 0)/2;
        
        System.out.println(ans);

    }
}

