import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251 {
    private static boolean[][][] isCheck = new boolean[201][201][201];
    private static boolean[] resultCheck = new boolean[201];
    private static int A, B, C;

    private static class Water {
        int A, B, C;

        public Water(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        solve(0, 0, C);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= C; i++) {
            if (resultCheck[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void solve(int a, int b, int c) {
        Queue<Water> queue = new LinkedList<>();
        queue.add(new Water(a, b, c));

        while (!queue.isEmpty()) {
            Water cur = queue.poll();
            if (isCheck[cur.A][cur.B][cur.C]) continue;

            isCheck[cur.A][cur.B][cur.C] = true;
            if (cur.A == 0) resultCheck[cur.C] = true;

            // A -> B
            if (cur.A + cur.B > B) {
                queue.add(new Water(cur.A + cur.B - B, B, cur.C));
            } else {
                queue.add(new Water(0, cur.A + cur.B, cur.C));
            }
            // A -> C
            if (cur.A + cur.C > C) {
                queue.add(new Water(cur.A + cur.C - C, cur.B, C));
            } else {
                queue.add(new Water(0, cur.B, cur.A + cur.C));
            }
            // B -> A
            if (cur.B + cur.A > A) {
                queue.add(new Water(A, cur.B + cur.A - A, cur.C));
            } else {
                queue.add(new Water(cur.A + cur.B, 0, cur.C));
            }
            // B -> C
            if (cur.B + cur.C > C) {
                queue.add(new Water(cur.A, cur.B + cur.C - C, C));
            } else {
                queue.add(new Water(cur.A, 0, cur.B + cur.C));
            }
            // C -> A
            if (cur.C + cur.A > A) {
                queue.add(new Water(A, cur.B, cur.C + cur.A - A));
            } else {
                queue.add(new Water(cur.C + cur.A, cur.B, 0));
            }
            // C -> B
            if (cur.C + cur.B > B) {
                queue.add(new Water(cur.A, B, cur.C + cur.B - B));
            } else {
                queue.add(new Water(cur.A, cur.B + cur.C, 0));
            }
        }
    }
}
