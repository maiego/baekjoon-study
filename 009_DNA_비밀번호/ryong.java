import java.util.Scanner;

class Main {
  static int[] need;
    // https://boj.kr/12891
    static boolean check(int[] cnt) {
      return cnt['A']>=need[0] && cnt['C']>=need[1] && cnt['G']>=need[2] && cnt['T']>=need[3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] s = sc.next().toCharArray();
        
        need = new int[4];
        for (int i=0; i<4; ++i)
          need[i] = sc.nextInt();

        int[] cnt = new int['z'];
        int ans = 0;
        for (int i=0; i<n; ++i) {
          ++cnt[s[i]];

          if (i>=m)
            --cnt[s[i-m]];

          if (i>=m-1 && check(cnt)) {
            ++ans;
          }
        }

        System.out.println(ans);
    }
}

