import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    private static int L, C;
    private static boolean[] isSelect;
    private static char[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        isSelect = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) arr[i] = st.nextToken().charAt(0);
        br.close();

        Arrays.sort(arr);
        solve(0, 0);
        System.out.print(sb);
    }

    private static void solve(int index, int count) {
        if (count == L) {
            int vowelsCount = 0, consonantsCount = 0;

            for (int i = 0; i < C; i++) {
                if (!isSelect[i]) continue;

                char c = arr[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelsCount++;
                else consonantsCount++;
            }

            if (vowelsCount < 1 || consonantsCount < 2) return;

            for (int i = 0; i < C; i++) {
                if (!isSelect[i]) continue;

                sb.append(arr[i]);
            }
            sb.append("\n");
            return;
        }

        for (; index < C; index++) {
            if (isSelect[index]) continue;

            isSelect[index] = true;
            solve(index + 1, count + 1);
            isSelect[index] = false;
        }
    }
}
