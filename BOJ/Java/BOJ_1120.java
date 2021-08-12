import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String A = st.nextToken(), B = st.nextToken();

        int minDiff = Integer.MAX_VALUE;
        int aLen = A.length(), bLen = B.length();

        for (int i = 0; i <= bLen - aLen; i++) {
            int count = 0;
            for (int j = 0; j < aLen; j++) {
                if (A.charAt(j) != B.charAt(i + j)) count++;
            }
            minDiff = Math.min(minDiff, count);
        }

        System.out.println(minDiff);
    }
}
