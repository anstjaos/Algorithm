import java.io.*;

public class BOJ_15688 {
    public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] countArr = new int[2000005];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            countArr[num + 1000000]++;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000005; i++) {
            if (countArr[i] > 0) {
                while (countArr[i] != 0) {
                    countArr[i]--;
                    sb.append(i - 1000000).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
