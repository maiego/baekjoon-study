import java.util.*;

public class Main {
    // https://boj.kr/11720
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();

        int acc = 0;
        for (char c: s) {
            acc += c-'0';
        }
        System.out.println(acc);
    }
}