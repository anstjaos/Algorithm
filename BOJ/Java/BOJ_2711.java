import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2711 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String input = st.nextToken();

            int length = input.length();
            for (int i = 0; i < length; i++) {
                if (i == num - 1) continue;
                sb.append(input.charAt(i));
            }
            sb.append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
