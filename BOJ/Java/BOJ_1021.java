import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] pick = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) pick[i] = Integer.parseInt(st.nextToken());
        br.close();

        boolean[] isPop = new boolean[N+1];
        int front = 1;

        int result = 0;
        for (int i = 0; i < M; i++) {
            int next = pick[i];

            int temp = front;
            int secondCount = 0;
            while (temp != next) {
                if (!isPop[temp]) secondCount++;
                temp++;
                if (temp == N + 1) temp = 1;
            }

            int thirdCount = 0;
            temp = front;
            while (temp != next) {
                if (!isPop[temp]) thirdCount++;
                temp--;
                if (temp == 0) temp = N;
            }

            result += Math.min(secondCount, thirdCount);
            isPop[next] = true;

            temp = next;
            if (i == M -1) break;
            while (isPop[temp]) {
                temp++;
                if (temp == N + 1) temp = 1;
            }
            front = temp;
        }

        System.out.println(result);
    }
}
