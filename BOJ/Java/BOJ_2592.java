import java.io.*;

public class BOJ_2592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[101];

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num / 10]++;
        }
        br.close();

        int maxCount = 0, maxVal = 0;
        for (int i = 0; i < 101; i++) {
            if (arr[i] > maxCount) {
                maxCount = arr[i];
                maxVal = i * 10;
            }
        }

        System.out.println(sum / 10);
        System.out.println(maxVal);
    }
}
