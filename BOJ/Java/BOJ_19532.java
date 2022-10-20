import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19532 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());

        int xResult = 0, yResult = 0;
        boolean isFind = false;
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if ((a * i + b * j == c) && (d * i + e * j == f)) {
                    xResult = i;
                    yResult = j;
                    isFind = true;
                    break;
                }
            }
            if (isFind) break;
        }
        br.close();
        System.out.println(xResult + " " + yResult);
    }
}
