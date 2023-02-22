import java.util.Scanner;

class Main {
    // https://boj.kr/1991

    static StringBuilder sb = new StringBuilder();
    static char[] left = new char['Z'+1];
    static char[] right = new char['Z'+1];

    static void preorder(char c) {
        if (c=='.') return;
        sb.append(c);
        preorder(left[c]);
        preorder(right[c]);
    }

    static void inorder(char c) {
        if (c=='.') return;
        inorder(left[c]);
        sb.append(c);
        inorder(right[c]);
    }

    static void postorder(char c) {
        if (c=='.') return;
        postorder(left[c]);
        postorder(right[c]);
        sb.append(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i=0; i<n; ++i) {
            char a = sc.next().toCharArray()[0];
            char b = sc.next().toCharArray()[0];
            char c = sc.next().toCharArray()[0];

            left[a] = b;
            right[a] = c;
        }

        preorder('A'); sb.append('\n');
        inorder('A'); sb.append('\n');
        postorder('A'); sb.append('\n');

        System.out.println(sb);
    }
}

