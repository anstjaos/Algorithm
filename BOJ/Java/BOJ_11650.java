import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650 {
    public static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point() {}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Point[] points = new Point[100005];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i].x + " " + points[i].y  + "\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
