import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2979 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] truck = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 3; i++) truck[i] = Integer.parseInt(st.nextToken());
        int[] time = new int[105];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) time[j]++;
        }
        br.close();

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += truck[time[i]] * time[i];
        }

        System.out.println(result);
    }
}
