import java.io.*;

public class BOJ_10996 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        if (N == 1) sb.append("*\n");
        else {
            for (int i = 0; i < N * 2; i++) {
                boolean spaceToggle = false;
                if (i % 2 == 1) spaceToggle = true;

                for (int j = 0; j < N; j++) {
                    if (spaceToggle) sb.append(" ");
                    else sb.append("*");

                    spaceToggle = !spaceToggle;
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
