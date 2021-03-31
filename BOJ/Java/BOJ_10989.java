import java.io.*;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10005];

        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
            maxNum = Math.max(num, maxNum);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxNum; i++) {
            if (arr[i] == 0) continue;

            while (arr[i] > 0) {
                sb.append(i + "\n");
                arr[i]--;
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}
