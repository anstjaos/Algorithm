import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2864 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String A = st.nextToken(), B = st.nextToken();

        A = changeNum(A, '6', '5');
        B = changeNum(B, '6', '5');

        int minNum = Integer.parseInt(A) + Integer.parseInt(B);

        A = changeNum(A, '5', '6');
        B = changeNum(B, '5', '6');

        int maxNum = Integer.parseInt(A) + Integer.parseInt(B);

        System.out.println(minNum + " " + maxNum);
    }

    private static String changeNum(String str, char from, char to) {
        int length = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == from) {
                result.append(to);
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
