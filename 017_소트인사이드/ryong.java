import java.util.Arrays;
import java.util.Scanner;

class Main {
    // https://boj.kr/1427

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char[] s = sc.next().toCharArray();

        Arrays.sort(s);
        for (int i=s.length-1; i>=0; --i)
          sb.append(s[i]);
        
          System.out.print(sb);
    }
}

