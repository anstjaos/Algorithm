import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2745 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int length = N.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            char c = N.charAt(i);
            int nextNum = 0;
            if (c <= '9') nextNum = c - '0';
            else {
                nextNum = c - 'A' + 10;
            }
            result = (result * B) + nextNum;
        }

        System.out.println(result);
    }
}
