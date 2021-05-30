import java.io.*;

public class BOJ_15988 {
    private static final int MAX_SIZE = 1000001;
    private static final int DIV = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[MAX_SIZE];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < MAX_SIZE; i++) {
            arr[i] = (arr[i-1] % DIV) + (arr[i-2] % DIV) + (arr[i-3] % DIV);
            arr[i] %= DIV;
        }

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num]).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
