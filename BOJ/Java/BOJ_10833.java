import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentCount = Integer.parseInt(st.nextToken());
            int appleCount = Integer.parseInt(st.nextToken());
            result += (appleCount % studentCount);
        }
        br.close();
        System.out.println(result);
    }
}
