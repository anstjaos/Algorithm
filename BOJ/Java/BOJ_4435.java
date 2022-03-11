import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4435 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] gandalf = {1, 2, 3, 3, 4, 10};
        int[] sauron = {1, 2, 2, 2, 3, 5, 10};

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gandalfSum = 0;
            for (int i = 0; i < 6; i++) {
                gandalfSum += (Integer.parseInt(st.nextToken()) * gandalf[i]);
            }

            st = new StringTokenizer(br.readLine());
            int sauronSum = 0;
            for (int i = 0; i < 7; i++) {
                sauronSum += (Integer.parseInt(st.nextToken()) * sauron[i]);
            }

            sb.append("Battle ").append(t).append(": ");
            if (gandalfSum > sauronSum) {
                sb.append("Good triumphs over Evil\n");
            } else if (gandalfSum < sauronSum) {
                sb.append("Evil eradicates all trace of Good\n");
            } else {
                sb.append("No victor on this battle field\n");
            }
        }
        br.close();

        System.out.print(sb);
    }
}
