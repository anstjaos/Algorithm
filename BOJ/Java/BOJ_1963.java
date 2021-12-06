import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
    private static boolean[] primeNum;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        primeNum = new boolean[10001];
        Arrays.fill(primeNum, true);
        primeNum[0] = primeNum[1] = false;

        for (int i = 2; i < 10001; i++) {
            if (primeNum[i]) {
                for (int j = i * i; j < 10001; j += i) primeNum[j] = false;
            }
        }
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            int result = solve(start, dest);
            if (result == Integer.MAX_VALUE) sb.append("Impossible\n");
            else sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static int solve(int start, int dest) {
        int result = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curNum = queue.poll();

            if (curNum == dest) {
                result = Math.min(result, dist[curNum]);
            }

            String sPos = "" + curNum;
            for (int i = 0; i < 4; i++) {
                for (int j = (i == 0 ? 1 : 0); j < 10; j++) {
                    int nextPos = Integer.parseInt(sPos.substring(0, i) + j + sPos.substring(i + 1));
                    int nextDist = dist[curNum] + 1;

                    if (primeNum[nextPos] && nextDist < dist[nextPos]) {
                        queue.add(nextPos);
                        dist[nextPos] = nextDist;
                    }
                }
            }
        }

        return result;
    }
}
