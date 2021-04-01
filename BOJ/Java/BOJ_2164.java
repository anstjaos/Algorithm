import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int rotate = 0;
        while (queue.size() != 1) {
            Integer num = queue.poll();
            if (rotate == 1) {
                queue.add(num);
            }

            rotate = rotate + 1;
            rotate %= 2;
        }

        Integer result = queue.poll();

        System.out.println(result.intValue());
        br.close();
    }
}
