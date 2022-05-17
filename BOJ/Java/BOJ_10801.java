import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10801 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] arrA = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) arrA[i] = Integer.parseInt(st.nextToken());

        int[] arrB = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) arrB[i] = Integer.parseInt(st.nextToken());
        br.close();

        int aWinCount = 0, bWinCount = 0;
        for (int i = 0; i < 10; i++) {
            if (arrA[i] >= arrB[i]) {
                aWinCount++;
            }

            if (arrA[i] <= arrB[i]) {
                bWinCount++;
            }
        }

        if (aWinCount == bWinCount) System.out.println("D");
        else if (aWinCount > bWinCount) System.out.println("A");
        else System.out.println("B");
    }
}
