import java.io.*;

public class BOJ_9507 {
    private static long[] fibo;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        fibo = new long[70];
        for (int i = 0; i <= 67; i++) fibo[i] = getFibo(i);

        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(fibo[num]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static long getFibo(int num) {
        if (num < 2) return 1;
        if (num == 2) return 2;
        if (num == 3) return 4;
        if (fibo[num] != 0) return fibo[num];

        return getFibo(num - 1) + getFibo(num - 2) + getFibo(num - 3) + getFibo(num - 4);
    }
}
