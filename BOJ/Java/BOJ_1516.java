import java.io.*;
import java.util.*;

public class BOJ_1516 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int[] incomeCount = new int[N];
        List<List<Integer>> nextBuild = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nextBuild.add(new ArrayList<>());
        }

        int[] buildTime = new int[N];
        int[] buildTimeSum = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            buildTime[i] = num;
            while (true) {
                num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                incomeCount[i]++;
                nextBuild.get(num - 1).add(i);
            }
        }
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (incomeCount[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            List<Integer> nextList = nextBuild.get(cur);
            for (Integer next : nextList) {
                buildTimeSum[next] = Math.max(buildTimeSum[next], buildTimeSum[cur] + buildTime[cur]);
                incomeCount[next]--;
                if (incomeCount[next] == 0) queue.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(buildTimeSum[i] + buildTime[i]).append("\n");
        System.out.print(sb);
    }
}
