import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_2957 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Long> mapArr = new TreeMap<>();

        mapArr.put(0, -1L);
        mapArr.put(300001, -1L);

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            Integer upperKey = mapArr.higherKey(num);
            Integer lowerKey = mapArr.lowerKey(num);

            long depth = 0;
            long upper = mapArr.get(upperKey);
            long lower = mapArr.get(lowerKey);

            depth = upper > lower ? upper + 1 : lower + 1;
            mapArr.put(num, depth);
            count += depth;
            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
