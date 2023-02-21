import java.util.Arrays;
import java.util.Scanner;

class Main {
    // https://boj.kr/1744

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; ++i)
          arr[i] = sc.nextInt();

        if (n==1) {
          System.out.println(arr[0]);
          return;
        }

        Arrays.sort(arr);

        boolean[] vis = new boolean[n];

        int ans = 0;
        for (int i=0; i+1<n; i+=2) {
          if (arr[i]>=0) break;
          if (arr[i+1]<0)
            ans += arr[i]*arr[i+1];
          else if (arr[i+1]>0)
            ans += arr[i];
          vis[i] = vis[i+1] = true;
        }

        for (int i=n-1; i-1>=0; i-=2) {
          if (arr[i]<=0) break;
          if (arr[i-1]>1)
            ans += arr[i]*arr[i-1];
          else if (arr[i-1]==1)
            ans += arr[i]+1;
          else
            ans += arr[i];
          vis[i] = vis[i-1] = true;
        }

        for (int i=0; i<n; ++i) {
          if (!vis[i]) ans += arr[i];
        }

        System.out.println(ans);
    }
}

