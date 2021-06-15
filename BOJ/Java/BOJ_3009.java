import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xArr = new int[3];
        int[] yArr = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xArr[i] = x;
            yArr[i] = y;
        }

        Arrays.sort(xArr);
        Arrays.sort(yArr);
        br.close();

        StringBuilder sb = new StringBuilder();
        if (xArr[0] == xArr[1]) sb.append(xArr[2]);
        else sb.append(xArr[0]);

        sb.append(" ");

        if (yArr[0] == yArr[1]) sb.append(yArr[2]);
        else sb.append(yArr[0]);

        System.out.println(sb);
    }
}
