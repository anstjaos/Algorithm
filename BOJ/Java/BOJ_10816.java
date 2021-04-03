import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (numberMap.containsKey(num)) {
                int count = numberMap.get(num);
                numberMap.replace(num, count+1);
            } else {
                numberMap.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (numberMap.containsKey(num)) {
                sb.append(numberMap.get(num) + " ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
