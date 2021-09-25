import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1717 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                union(a, b);
            } else {
                a = findParent(a);
                b = findParent(b);

                if (a == b) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        br.close();

        System.out.print(sb);
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
