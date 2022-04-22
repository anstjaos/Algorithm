import java.io.*;

public class BOJ_2851 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] mushrooms = new int[10];
        int[] sums = new int[10];

        int diff = 100, result = 0;
        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(br.readLine());
            if (i == 0) sums[0] = mushrooms[0];
            else sums[i] = sums[i - 1] + mushrooms[i];

            int tempDiff = Math.abs(100 - sums[i]);
            if (tempDiff == diff) {
                result = Math.max(result, sums[i]);
            } else if (tempDiff < diff) {
                diff = tempDiff;
                result = sums[i];
            }
        }
        br.close();

        System.out.println(result);
    }
}
