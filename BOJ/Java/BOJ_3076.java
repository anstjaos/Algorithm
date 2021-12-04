import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3076 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        br.close();

        char[][] map = new char[R*A][C*B];

        for (int i = 0; i < R*A; i+=A) {
            for (int j = 0; j < C*B; j+=B) {
                char c  = '.';
                if((i/A % 2 == 0 && j/B % 2 == 0) || (i/A % 2 != 0 && j/B % 2 != 0)) {
                    c = 'X';
                }

                for (int a = i; a < i+A ; a++) {
                    for (int b = j; b < j+B; b++) {
                        map[a][b] = c;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R*A; i++) {
            sb.append(map[i]);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
