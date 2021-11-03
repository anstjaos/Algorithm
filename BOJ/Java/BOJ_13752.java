import java.io.*;

public class BOJ_13752 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) sb.append("=");
            sb.append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
