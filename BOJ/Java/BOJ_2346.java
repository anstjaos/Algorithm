import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {
    private static class Ballon {
        int idx, num;

        public Ballon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Ballon> que = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int next = Integer.parseInt(st.nextToken());
            que.add(new Ballon(i, next));
        }

        while(!que.isEmpty()) {
            sb.append(que.getFirst().idx + " ");
            int next = que.poll().num;
            if(que.isEmpty()) break;

            if(next > 0) {
                next -= 1;
                for(int i = 0; i < next; i++) {
                    que.addLast(que.pollFirst());
                }
            }else {
                for(int i = 0; i < Math.abs(next); i++) {
                    que.addFirst(que.pollLast());
                }
            }
        }
        System.out.println(sb.toString());
    }
}
