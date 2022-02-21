import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2511 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] aScore = new int[10], bScore = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            aScore[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            bScore[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int lastWinner = -1;
        int aTotal = 0, bTotal = 0;
        for (int i = 0; i < 10; i++) {
            if (aScore[i] > bScore[i]) {
                aTotal += 3;
                lastWinner = 1;
            } else if (aScore[i] < bScore[i]) {
                bTotal += 3;
                lastWinner = 2;
            } else {
                aTotal += 1;
                bTotal += 1;
            }
        }

        System.out.println(aTotal + " " + bTotal);
        char result = 'A';
        if (aTotal > bTotal) {
            result = 'A';
        } else if (aTotal < bTotal) {
            result = 'B';
        } else {
            if (lastWinner == -1) {
                result = 'D';
            } else if (lastWinner == 1) {
                result = 'A';
            } else {
                result = 'B';
            }
        }

        System.out.println(result);
    }
}
