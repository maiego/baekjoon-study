import java.util.*;

class Main {
    // https://boj.kr/2251

    static int f(int a, int b, int c) {
      return 201*201*a + 201*b + c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        List<Integer> ans = new ArrayList<>();
        boolean[] ansVis = new boolean[201];
        HashSet<Integer> vis = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(c);
        while (!q.isEmpty()) {
          int h = q.poll();
          if (vis.contains(h)) continue;
          vis.add(h);

          int cc = (int)h%201; h/=201;
          int bb = (int)h%201; h/=201;
          int aa = (int)h%201;

          if (aa==0 && !ansVis[cc]) {
            ans.add(cc);
            ansVis[cc] = true;
          }

          int x = 0;

          //a->b
          x = Math.min(b-bb, aa);
          q.add(f(aa-x, bb+x, cc));
          //a->c
          x = Math.min(c-cc, aa);
          q.add(f(aa-x, bb, cc+x));

          //b->c
          x = Math.min(c-cc, bb);
          q.add(f(aa, bb-x, cc+x));
          //b->a
          x = Math.min(a-aa, bb);
          q.add(f(aa+x, bb-x, cc));

          //c->a
          x = Math.min(a-aa, cc);
          q.add(f(aa+x, bb, cc-x));
          //c->b
          x = Math.min(b-bb, cc);
          q.add(f(aa, bb+x, cc-x));

        }

        Collections.sort(ans);
        for (int x: ans)
          System.out.print(x + " ");

    }
}