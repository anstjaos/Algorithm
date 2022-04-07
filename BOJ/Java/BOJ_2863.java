import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2863 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] arr = new int[4];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) arr[i * 2 + j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        double maxValue =  ((double)arr[0] / (double)arr[2]) + ((double)arr[1] / (double)arr[3]);
        int maxIndex = 0;

        for (int i = 0; i < 3; i++) {
            int temp = arr[0];
            arr[0] = arr[2];
            arr[2] = arr[3];
            arr[3] = arr[1];
            arr[1] = temp;

            double tempVal = ((double)arr[0] / (double)arr[2]) + ((double)arr[1] / (double)arr[3]);
            if (tempVal > maxValue) {
                maxValue = tempVal;
                maxIndex = i + 1;
            }
        }

        System.out.println(maxIndex);
    }
}
