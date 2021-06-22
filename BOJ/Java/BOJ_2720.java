import java.io.*;

public class BOJ_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int[] arr = new int[4];

            arr[0] = c / 25;
            c -= 25 * arr[0];

            arr[1] = c / 10;
            c -= 10 * arr[1];

            arr[2] = c / 5;
            c -= 5 * arr[2];

            arr[3] = c;

            for (int i = 0; i < 4; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
