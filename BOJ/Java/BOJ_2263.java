import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2263 {
    private static StringBuilder sb;
    private static int N;
    private static int[] inOrderIdx, postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inOrderIdx = new int[N+1];
        postOrder = new int[N];
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrderIdx[Integer.parseInt(st.nextToken())] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) postOrder[i] = Integer.parseInt(st.nextToken());
        br.close();

        solve(0, N-1, 0, N-1);
        System.out.println(sb);
    }

    private static void solve(int inOrderStart, int inOrderEnd, int preOrderStart, int preOrderEnd) {
        if (inOrderStart > inOrderEnd || preOrderStart > preOrderEnd) return;
        sb.append(postOrder[preOrderEnd]).append(" ");

        int index = inOrderIdx[postOrder[preOrderEnd]];
        int left = index-inOrderStart;
        solve(inOrderStart, index - 1, preOrderStart, preOrderStart + left - 1);
        solve(index + 1, inOrderEnd, preOrderStart + left, preOrderEnd - 1);
    }
}
