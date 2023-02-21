import java.util.Scanner;

class Main {
    // https://boj.kr/1850

    static long gcd(long a, long b) {
      return b==0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        StringBuilder sb = new StringBuilder();
        long g = gcd(a,b);
        for (int i=0; i<g; ++i)
          sb.append('1');

        System.out.println(sb);

        // JDK11
        // System.out.println("1".repeat((int)gcd(a,b)));
    }
}

