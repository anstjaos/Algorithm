import java.io.*;
import java.util.*;

public class BOJ_16928 {
    private static class Move {
        int cur;
        int count;

        public Move(int cur, int count) {
            this.cur = cur;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Integer> snake = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(1, 0));

        int result = Integer.MAX_VALUE;
        int[] count = new int[101];
        Arrays.fill(count, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            Move cur = queue.poll();
            if (cur.cur == 100) {
                result = Math.min(result, cur.count);
                continue;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur.cur + i;
                if (next <= 0 || next > 100) continue;
                if (ladder.containsKey(next)) next = ladder.get(next);
                if (snake.containsKey(next)) next = snake.get(next);
                if (count[next] <= cur.count + 1) continue;

                count[next] = cur.count + 1;
                queue.add(new Move(next, cur.count + 1));
            }
        }

        System.out.println(result);
        br.close();
    }
}
