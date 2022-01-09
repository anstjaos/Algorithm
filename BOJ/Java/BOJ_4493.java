import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4493 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int player1 = 0, player2 = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char p1 = st.nextToken().charAt(0), p2 = st.nextToken().charAt(0);

                if (p1 == 'R') {
                    if (p2 == 'R') continue;
                    else if (p2 == 'P') player2++;
                    else player1++;
                } else if (p1 == 'P') {
                    if (p2 == 'R') player1++;
                    else if (p2 == 'P') continue;
                    else player2++;
                } else {
                    if (p2 == 'R') player2++;
                    else if (p2 == 'P') player1++;
                }
            }
            if (player1 > player2) sb.append("Player 1").append("\n");
            else if (player1 < player2) sb.append("Player 2").append("\n");
            else sb.append("TIE").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
