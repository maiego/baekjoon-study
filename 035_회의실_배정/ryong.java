import java.util.Arrays;
import java.util.Scanner;

class Main {
    // https://boj.kr/1931

    static class Item {
      int s,e;
      Item(int a, int b) {
        s=a; e=b;
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Item[] arr = new Item[n];
        for (int i=0; i<n; ++i) {
          arr[i] = new Item(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr, (a,b)->{
          if (a.e!=b.e)
            return a.e-b.e;
          return a.s-b.s;
        });
        
        int time=0, cnt=0;
        for (Item item: arr) {
          if (item.s<time) continue;
          ++cnt;
          time = item.e;
        }
        System.out.println(cnt);

    }
}