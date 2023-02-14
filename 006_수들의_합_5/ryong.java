import java.util.Scanner;

class Main {
    // https://boj.kr/2018

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans=0, sum=0;
        int l=0, r=0;
        while (l<=r && r<=n) {
          if (sum==n)
            ++ans;
          if (sum<=n)
            sum += ++r;
          else sum -= l++;
        }

        System.out.println(ans);

    }
}

