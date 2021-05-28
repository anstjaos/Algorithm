import java.io.*;
import java.util.*;

public class BOJ_13023 {
    private static boolean[] visit;
    private static int N, M;
    private static Map<Integer, List<Integer>> isFriend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        isFriend = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            isFriend.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            isFriend.get(a).add(b);
            isFriend.get(b).add(a);
        }
        br.close();

        boolean result = false;
        for (int i = 0; i < N; i++) {
            if (solve(i, 1)) {
                result = true;
                break;
            }
        }

        System.out.println(result ? 1 : 0);
    }

    private static boolean solve(int index, int depth) {
        if (depth == 5) {
            return true;
        }

        visit[index] = true;
        List<Integer> list = isFriend.get(index);
        for (Integer next : list) {
            if (!visit[next]) {
                if (solve(next, depth + 1)) return true;
            }
        }
        visit[index] = false;

        return false;
    }
}
