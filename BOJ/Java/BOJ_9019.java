import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    private static class Num {
        int num;
        String order;

        public Num(int num, String order) {
            this.num = num;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

            Queue<Num> queue = new LinkedList<>();
            queue.add(new Num(A,  ""));

            String order = "";
            boolean[] visit = new boolean[10000];
            while (!queue.isEmpty()) {
                Num cur = queue.poll();
                if (cur.num == B) {
                    order = cur.order;
                    break;
                }

                int next = (cur.num * 2) % 10000;
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(new Num(next, cur.order + "D" ));
                }

                next = cur.num == 0 ? 9999 : cur.num - 1;
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(new Num(next, cur.order + "S" ));
                }

                next = (cur.num * 10 + (cur.num * 10 / 10000)) % 10000;
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(new Num(next, cur.order + "L"));
                }

                next = cur.num / 10 + ((cur.num % 10) * 1000);
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(new Num(next, cur.order + "R"));
                }
            }
            sb.append(order).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
