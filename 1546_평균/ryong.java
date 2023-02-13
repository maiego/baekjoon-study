import java.util.*;

public class Main {
    // https://boj.kr/1546

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        int sum=0, maxv=-1;
        for (int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            maxv = Math.max(maxv, arr[i]);
        }

        System.out.println(sum*100.0 /maxv / n);
    }
}