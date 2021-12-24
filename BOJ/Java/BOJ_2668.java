import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668 {
    private static boolean[] isVisit;
    private static int[] arr;
    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+5];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        isVisit = new boolean[N+5];

        result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            isVisit[i] = true;
            dfs(i, i);
            isVisit[i] = false;
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int cur, int target) {
        if (!isVisit[arr[cur]]) {
            isVisit[arr[cur]] = true;
            dfs(arr[cur], target);
            isVisit[arr[cur]] = false;
        }
        if (arr[cur] == target) result.add(target);
    }
}
