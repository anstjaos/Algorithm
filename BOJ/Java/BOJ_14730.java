import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14730 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int result = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            result += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }
        br.close();
        System.out.println(result);
    }
}
