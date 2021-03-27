import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minNum = 1999999;
        int maxNum = -1999999;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        System.out.println(minNum + " " + maxNum);
        br.close();
    }
}
