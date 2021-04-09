import java.io.*;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] fibonacci = new int[41][2];

        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;

        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
            fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
        }

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(fibonacci[num][0] + " " + fibonacci[num][1]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
