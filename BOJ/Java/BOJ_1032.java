import java.io.*;

public class BOJ_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine();
        br.close();

        int len = arr[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            boolean isSame = true;
            for (int j = 1; j < N; j++) {
                if (arr[j].charAt(i) != arr[j-1].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) sb.append(arr[0].charAt(i));
            else sb.append('?');
        }

        System.out.println(sb);
    }
}
