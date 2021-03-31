import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[100005];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean findNum = false;
            for (int j = 0; j < N; j++) {
                if (arr[j] == num) {
                    findNum = true;
                    break;
                }
            }

            if (findNum) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
