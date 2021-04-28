import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
    private static class Num {
        long cur;
        int count;

        public Num(long cur, int count) {
            this.cur = cur;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        Queue<Num> queue = new LinkedList<>();
        queue.add(new Num(A, 1));
        int result = -1;
        while (!queue.isEmpty()) {
            Num cur = queue.poll();
            if (cur.cur == B) {
                result = cur.count;
                break;
            }

            if (cur.cur * 2 <= B) queue.add(new Num(cur.cur*2, cur.count + 1));
            if (cur.cur * 10 + 1 <= B) queue.add(new Num(cur.cur * 10 + 1, cur.count + 1));
        }

        System.out.println(result);
        br.close();
    }
}
