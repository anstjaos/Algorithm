import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1267 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int yVal = 0, mVal = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            yVal += (cur / 30) * 10;
            int temp = cur - ((cur / 30) * 30);
            if (cur % 30 == 0 || temp < 30) yVal += 10;

            mVal += (cur / 60) * 15;
            temp = cur - ((cur / 60) * 60);
            if (cur % 60 == 0 || temp < 60) mVal += 15;
        }
        br.close();

        if (yVal < mVal) {
            System.out.println("Y " + yVal);
        } else if (yVal > mVal) {
            System.out.println("M " + mVal);
        } else System.out.println("Y M " + yVal);
    }
}
