import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothCount = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();

                if (clothCount.containsKey(category)) {
                    clothCount.put(category, clothCount.get(category) + 1);
                } else {
                    clothCount.put(category, 1);
                }
            }

            int result = 1;
            Set<String> categories = clothCount.keySet();

            for (String category : categories) {
                result *= (clothCount.get(category) + 1);
            }
            sb.append(result - 1).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
