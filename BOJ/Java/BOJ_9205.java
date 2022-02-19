import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point start, end;
    private static int n;
    private static Point[] conveniences;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            conveniences = new Point[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                conveniences[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (solve()) sb.append("happy\n");
            else sb.append("sad\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static boolean solve() {
        boolean[] isVisit = new boolean[n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if ((Math.abs(end.x - cur.x) + Math.abs(end.y - cur.y)) <= 1000) return true;

            for (int i = 0; i < n; i++) {
                if (isVisit[i]) continue;

                if ((Math.abs(conveniences[i].x - cur.x) + Math.abs(conveniences[i].y - cur.y)) <= 1000) {
                    isVisit[i] = true;
                    queue.add(conveniences[i]);
                }
            }
        }

        return false;
    }
}
