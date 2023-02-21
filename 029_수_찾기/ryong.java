import java.util.*;

class Main {
    // https://boj.kr/1920

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; ++i)
          arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int q = sc.nextInt();
        for (int i=0; i<q; ++i) {
          int x = sc.nextInt();
          int idx = Arrays.binarySearch(arr, x);
          sb.append(idx<0 ? 0 : 1).append('\n');
        }
        System.out.println(sb);

    }
}