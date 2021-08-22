import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11098 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int p = Integer.parseInt(br.readLine());
            int maxCost = Integer.MIN_VALUE;
            String name = "";
            for (int i = 0; i < p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cost = Integer.parseInt(st.nextToken());
                if (cost > maxCost) {
                    name = st.nextToken();
                    maxCost = cost;
                }
            }

            sb.append(name).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
