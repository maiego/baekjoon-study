import java.util.*;

class Main {
    // https://boj.kr/11659
    static int n,m;
    static int[] arr, pref;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        pref = new int[n+1];

        for (int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
            pref[i+1] = pref[i] + arr[i];
        }

        while (m-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sb.append(pref[b] - pref[a-1]);
            sb.append('\n');
        }
        System.out.println(sb);

    }
}