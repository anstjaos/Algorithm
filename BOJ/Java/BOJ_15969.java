import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15969 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            minVal = Math.min(num, minVal);
            maxVal = Math.max(num, maxVal);
        }

        System.out.println(maxVal - minVal);
    }
}
