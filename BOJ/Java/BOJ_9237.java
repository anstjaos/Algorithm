import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_9237 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, list.get(i - 1) + 1 + i);
        }
        System.out.println(result);
    }
}
