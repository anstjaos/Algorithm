import java.io.*;
import java.util.*;

public class BOJ_2304 {
    private static class Point {
        int left, right, height;

        public Point(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("BOJ/test.txt"));
        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = left+1;
            int height = Integer.parseInt(st.nextToken());
            points.add(new Point(left, right, height));
        }

        points.sort(Comparator.comparingInt(p -> p.left));

        int area = 0;
        int tallestPillarIndex = 0;
        Point point = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point current = points.get(i);
            if(point.height <= current.height) {
                int width = current.left - point.left;
                area += width * point.height;

                point = current;
                tallestPillarIndex = i;
            }
        }

        point = points.get(points.size()-1);
        for (int i = 1; i < points.size()-tallestPillarIndex; i++) {
            Point current = points.get(points.size()-i-1);
            if(point.height <= current.height) {
                int width = point.right - current.right;
                area += width * point.height;

                point = current;
            }
        }

        area += point.height;
        System.out.println(area);
    }

}
