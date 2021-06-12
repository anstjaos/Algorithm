import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    private static class Node {
        int num, depth;

        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        int[] depth = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            parent[y] = x;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (parent[i] == 0) {
                queue.add(new Node(i, 0));
                while (!queue.isEmpty()) {
                    Node cur = queue.poll();
                    for (int j = 1; j <= n; j++) {
                        if (parent[j] == cur.num) {
                            depth[j] = cur.depth + 1;
                            queue.add(new Node(j, depth[j]));
                        }
                    }
                }
            }
        }

        int result = 0;
        if (depth[a] == depth[b]) {
            while (a != b) {
                a = parent[a];
                b = parent[b];
                result += 2;
                if (a == 0 || b == 0) {
                    result = -1;
                    break;
                }
            }
        } else if (depth[a] > depth[b]){
            while (depth[a] != depth[b]) {
                a = parent[a];
                result++;
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
                result += 2;
                if (a == 0 || b == 0) {
                    result = -1;
                    break;
                }
            }
        } else {
            while (depth[a] != depth[b]) {
                b = parent[b];
                result++;
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
                result += 2;
                if (a == 0 || b == 0) {
                    result = -1;
                    break;
                }
            }
        }
        br.close();
        System.out.println(result);
    }
}
