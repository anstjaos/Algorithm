import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5596 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = 0;
        for (int i = 0; i < 4; i++) {
            S += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = 0;
        for (int i = 0; i < 4; i++) {
            T += Integer.parseInt(st.nextToken());
        }
        br.close();

        if (S >= T) System.out.println(S);
        else System.out.println(T);
    }
}
