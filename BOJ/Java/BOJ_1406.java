import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1406 {
    private static class Cursor {
        char c;
        Cursor left, right;

        public Cursor(char c, Cursor left, Cursor right) {
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Cursor start = new Cursor('a', null, null);
        Cursor cur = start;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            Cursor newCursor = new Cursor(c, cur, null);
            cur.right = newCursor;
            cur = newCursor;
        }
        cur.right = null;

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String order = br.readLine();

            char o = order.charAt(0);
            switch (o) {
                case 'L':
                    if (cur.left != null) cur = cur.left;
                    break;
                case 'D':
                    if (cur.right != null) cur = cur.right;
                    break;
                case 'B':
                    if (cur == start) continue;

                    cur.left.right = cur.right;
                    if (cur.right != null) cur.right.left = cur.left;
                    cur = cur.left;
                    break;
                case 'P':
                    Cursor newCursor = new Cursor(order.charAt(2), cur, cur.right);
                    if (cur.right != null) {
                        cur.right.left = newCursor;
                    }
                    cur.right = newCursor;
                    cur = newCursor;
                    break;
            }
        }

        br.close();
        StringBuilder sb = new StringBuilder();
        cur = start.right;
        while (cur != null) {
            sb.append(cur.c);
            cur = cur.right;
        }
        System.out.println(sb);
    }
}
