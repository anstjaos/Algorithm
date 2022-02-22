import java.io.*;

public class BOJ_13015 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        br.close();
        StringBuilder sb = new StringBuilder();

        int length = 1, blank = 0;
        for (int i = 2; i < N; i++) length += 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < blank; j++) sb.append(" ");
            for (int j = 0; j < N; j++) {
                if (i == 0) sb.append("*");
                else {
                    if (j == 0 || j == N - 1) {
                        if (i == N -1 && j == N -1) continue;
                        sb.append("*");
                    } else sb.append(" ");
                }
            }

            for (int j = 0; j < length; j++) sb.append(" ");
            blank++;
            length -= 2;

            for (int j = 0; j < N; j++) {
                if (i == 0) sb.append("*");
                else {
                    if (j == 0 || j == N - 1) sb.append("*");
                    else sb.append(" ");
                }
            }
            sb.append("\n");
        }

        length = 1;
        blank--;
        for (int i = 0; i < N - 1; i++) {
            blank--;
            for (int j = 0; j < blank; j++) sb.append(" ");
            for (int j = 0; j < N; j++) {
                if (i == N - 2) sb.append("*");
                else {
                    if (j == 0 || j == N - 1) sb.append("*");
                    else sb.append(" ");
                }
            }

            for (int j = 0; j < length; j++) sb.append(" ");
            for (int j = 0; j < N; j++) {
                if (i == N - 2) sb.append("*");
                else {
                    if (j == 0 || j == N - 1) sb.append("*");
                    else sb.append(" ");
                }
            }
            sb.append("\n");
            length += 2;
        }

        System.out.print(sb);
    }
}
