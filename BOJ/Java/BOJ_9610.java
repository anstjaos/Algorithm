import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9610 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) arr[0]++;
            else if (x > 0 && y > 0) arr[1]++;
            else if (x < 0 && y > 0) arr[2]++;
            else if (x < 0 && y < 0) arr[3]++;
            else if (x > 0 && y < 0) arr[4]++;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append("Q1: ").append(arr[1]).append("\n")
                .append("Q2: ").append(arr[2]).append("\n")
                .append("Q3: ").append(arr[3]).append("\n")
                .append("Q4: ").append(arr[4]).append("\n")
                .append("AXIS: ").append(arr[0]).append("\n");

        System.out.print(sb);
    }
}
