import java.io.*;

public class BOJ_1992 {
    private static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        solve(sb, 0, 0, N);
        System.out.println(sb);
        br.close();
    }

    private static void solve(StringBuilder sb, int x, int y, int size) {
        char cur = arr[x].charAt(y);
        boolean isAllSame = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[x+i].charAt(y + j) != cur) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) break;
        }
        if (isAllSame) {
            sb.append(cur);
            return;
        }

        sb.append('(');

        solve(sb, x, y, size/2);
        solve(sb, x, y + size/2, size/2);
        solve(sb, x + size/2, y, size/2);
        solve(sb, x+ size/2, y + size/2, size/2);

        sb.append(')');
    }
}
