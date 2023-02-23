import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    // https://boj.kr/1517
    static int n;
    static int[] fen;

    static int qry(int x) {
      int ret=0;
      while (x>0) {
        ret += fen[x];
        x -= x&-x;
      }
      return ret;
    }

    static void upt(int x) {
      while (x<n+10) {
        fen[x]++;
        x += x&-x;
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // n<=5e5
        int[] arr = new int[n];
        for (int i=0; i<n; ++i)
          arr[i] = sc.nextInt();
          
        fen = new int[n+10];
        Map<Integer, Integer> ord = new HashMap<>();
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);

        // 0 <= arr[i] <= 1e9 이기 때문에 좌표압축이 필요.
        int id = 2;
        for (int i=0; i<n; ++i) {
          if (ord.containsKey(sorted[i]))
            continue;
          ord.put(sorted[i], id++);
        }

        // 지금 값보다 작으면서 오른쪽에 있는 값의 개수(inversion count) 누적 
        long ans = 0;
        for (int i=n-1; i>=0; --i) {
          int x = ord.get(arr[i]);
          ans += qry(x-1);
          upt(x);
        }
        System.out.println(ans);

    }
}

