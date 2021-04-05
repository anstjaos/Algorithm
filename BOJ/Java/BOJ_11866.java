import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;

            if (count != K) {
                queue.add(num);
            } else {
                count = 0;
                sb.append(num).append(", ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        System.out.println(sb.toString());
        br.close();
    }
}
