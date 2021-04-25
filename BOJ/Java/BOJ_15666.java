import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15666 {
    private static int N, M;
    private static Set<Integer> set;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        result = new int[M];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        StringBuilder sb = new StringBuilder();
        dfs(0, 0, sb);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int curCount, int curIndex, StringBuilder sb) {
        if (curCount == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt((Integer a) -> a));

        for (int i = curIndex; i < list.size(); i++) {
            int num = list.get(i);

            result[curCount] = num;
            dfs(curCount + 1, i, sb);
        }
    }
}
