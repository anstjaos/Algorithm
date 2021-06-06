import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            for (int j = 0; j < 4; j++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            switch (arr[0]) {
                case 0:
                    sb.append("E\n");
                    break;
                case 1:
                    sb.append("A\n");
                    break;
                case 2:
                    sb.append("B\n");
                    break;
                case 3:
                    sb.append("C\n");
                    break;
                case 4:
                    sb.append("D\n");
                    break;
            }
        }
        br.close();

        System.out.print(sb);
    }
}
