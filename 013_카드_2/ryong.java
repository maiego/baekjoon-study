import java.util.*;

class Main {
    // https://boj.kr/2164

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Deque<Integer> q = new ArrayDeque<>();
        for (int i=1; i<=n; ++i) {
          q.add(i);
        }

        while (q.size()!=1) {
          q.poll();
          q.add(q.poll());
        }

        System.out.println(q.peek());

    }
}

