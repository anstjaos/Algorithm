import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9047 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            String num = br.readLine();

            int count = 0;
            while (!num.equals("6174")) {
                int numLength = num.length();
                char[] arr = num.toCharArray();
                Arrays.sort(arr);

                int maxNum = 0, minNum = 0;
                for (int j = 0; j < numLength; j++) {
                    minNum = minNum * 10 + (arr[j] - '0');
                    maxNum = maxNum * 10 + (arr[numLength - 1 - j] - '0');
                }
                for (int j = 0; j < 4 - numLength; j++) {
                    maxNum *= 10;
                }

                num = String.valueOf(maxNum - minNum);
                count++;
            }
            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
