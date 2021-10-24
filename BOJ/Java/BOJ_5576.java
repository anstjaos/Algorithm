import java.io.*;
import java.util.Arrays;

public class BOJ_5576 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] wArr = new int[10];
        int[] kArr = new int[10];

        for (int i = 0; i < 10; i++) wArr[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) kArr[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(wArr);
        Arrays.sort(kArr);

        System.out.println((wArr[7] + wArr[8] + wArr[9]) + " " + (kArr[7] + kArr[8] + kArr[9]));
    }
}
