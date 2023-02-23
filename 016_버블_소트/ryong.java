import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    // https://boj.kr/1377

    static int[] fen = new int[1000020];

    static int qry(int x) {
      int ret = 0;
      while (x>0) {
        ret += fen[x];
        x -= x&-x;
      }
      return ret;
    }

    static void upt(int x) {
      while (x<1000020) {
        fen[x]++;
        x += x&-x;
      }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n ;++i)
          arr[i] = Integer.parseInt(br.readLine());

        // 현재 값보다 큰 값이 몇번 나왔는지 (inversion count) 의 max 값이 답이된다.
        // 자신과 같은 값은 세면 안되기 때문에 arr[i]+1 이상 값이 몇번 나왔는지 세야한다.(중요)
        // inv_cnt 의 max값이 답이 되는 이유는 inv cnt가 버블정렬 시에 자신을 지나쳐가는 횟수이기 때문이다.
        // .---->...---->. 와 같은 경우 한번만 수행하면 되기 때문에 겹치는 최대횟수가 답이 된다..!  
        int maxv = (int)1e6+1;
        int ans = 0;
        for (int i=0; i<n; ++i) {
          ans = Math.max(ans, qry(maxv-arr[i]-1));
          upt(maxv-arr[i]);
        }

        System.out.println(ans+1); // 정렬된 상태도 한번을 소요하므로 +1

    }
}

