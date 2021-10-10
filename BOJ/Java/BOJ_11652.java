import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> count = new HashMap<>();
        int maxCount = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            int c = count.getOrDefault(num, 0);
            c++;
            if (c > maxCount) {
                result = num;
                maxCount = c;
            } else if (c == maxCount) result = Math.min(result, num);
            count.put(num, c);
        }
        br.close();
        System.out.println(result);
    }
}
