import java.util.*;

class Main {
    // https://boj.kr/11286

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> {
          int aa=Math.abs(a), bb=Math.abs(b);
          return aa==bb ? a-b : aa-bb;
        });

        while (n-->0) {
          int x = sc.nextInt();
          if (x==0) {
            sb.append(q.isEmpty() ? 0 : q.poll()).append('\n');
          } else q.add(x);
        }

        System.out.println(sb);
    }
}

