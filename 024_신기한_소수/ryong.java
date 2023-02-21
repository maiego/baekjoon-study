import java.util.*;

class Main {
    // https://boj.kr/2023

    static int n;
    static List<Integer> list[];

    static void dfs(int x, int k) {
      list[k].add(x);
      if (k==n) return;

      for (int i=1; i<=9; i+=2) {
        int xx = x*10+i;
        if (isPrime(xx))
          dfs(xx, k+1);
      }
    }

    static boolean isPrime(int x) {
      if (x==1) return false;
      if (x==2) return true;

      for (int i=2; 1L*i*i<=x; ++i)
        if (x%i == 0) return false;
      return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        list = new List[n+1];
        for (int i=1; i<=n; ++i)
          list[i] = new ArrayList<>();

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

        Collections.sort(list[n]);
        for (int x: list[n])
          sb.append(x).append('\n');

        System.out.println(sb);
    }
}

