import java.util.Scanner;

class Main {
    // https://boj.kr/1934

    static int gcd(int a, int b) {
      return b==0 ? a : gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-->0) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          System.out.println(a/gcd(a,b) * b);
        }


    }
}