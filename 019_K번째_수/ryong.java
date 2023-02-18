import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  // https://boj.kr/11004

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    // Tim sort 사용을 위해 Object 배열로 선언
    Integer[] arr = new Integer[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i)
      arr[i] = Integer.parseInt(st.nextToken());

    // int[] 는 dual pivot quick sort로 저격 테스트케이스가 존재!
    Arrays.sort(arr);
    System.out.println(arr[k - 1]);

  }
}
