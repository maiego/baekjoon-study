import java.util.Scanner;

class Main {
    // https://boj.kr/1541

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();

        int ans = 0;
        boolean flag = false;
        int x = 0;
        for (char c: input) {
          if (c=='-') {
            ans += flag ? -x : x;
            x = 0;
            flag = true;
          } else if (c=='+') {
            ans += flag ? -x : x;
            x = 0;
          } else {
            x = 10*x + c-'0';
          }
        }
        ans += flag ? -x : x;

        System.out.println(ans);

    }
}

