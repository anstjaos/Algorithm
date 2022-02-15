import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    private static class Floor{
        int cur, count;

        public Floor(int cur, int count) {
            this.cur = cur;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxFloor = Integer.parseInt(st.nextToken()), cur = Integer.parseInt(st.nextToken()), dest = Integer.parseInt(st.nextToken()),
                upBtn = Integer.parseInt(st.nextToken()), downBtn = Integer.parseInt(st.nextToken());
        br.close();

        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(cur, 0));
        boolean[] visit = new boolean[maxFloor + 5];
        visit[cur] = true;

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Floor curFloor = queue.poll();
            if (curFloor.cur == dest) {
                result = curFloor.count;
                break;
            }

            int up = curFloor.cur + upBtn;
            if (up <= maxFloor && !visit[up]) {
                visit[up] = true;
                queue.add(new Floor(up, curFloor.count + 1));
            }

            int down = curFloor.cur - downBtn;
            if (down >= 1 && !visit[down]) {
                visit[down] = true;
                queue.add(new Floor(down, curFloor.count + 1));
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? "use the stairs" : result);
    }
}
