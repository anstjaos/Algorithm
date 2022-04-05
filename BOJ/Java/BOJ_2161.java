import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2161 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");

            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        System.out.println(sb);
    }
}
