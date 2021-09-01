import java.io.*;
import java.util.*;

public class BOJ_1068 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> childList = new ArrayList<>();
        for (int i = 0; i < N; i++) childList.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == -1) {
                root = i;
                continue;
            }

            childList.get(cur).add(i);
        }

        int removeNode = Integer.parseInt(br.readLine());
        br.close();

        if (removeNode == root) {
            System.out.println(0);
            return;
        }

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int childCount = 0;
            for (Integer child : childList.get(cur)) {
                if (child == removeNode) continue;

                queue.add(child);
                childCount++;
            }

            if (childCount == 0) result++;
        }

        System.out.println(result);
    }
}
