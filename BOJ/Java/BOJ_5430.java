import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String input = br.readLine();
            int arrCount = Integer.parseInt(br.readLine());
            String nums = br.readLine();
            int[] arr = new int[arrCount + 1];
            nums = nums.substring(1, nums.length()-1);
            StringTokenizer st = new StringTokenizer(nums, ",");
            for (int i = 0; i < arrCount; i++) {
                arr[i + 1] = Integer.parseInt(st.nextToken());
            }

            int front = 0, rear = arrCount;
            boolean isReversed = false;

            int inputLen = input.length();
            boolean isError = false;
            for (int i = 0; i < inputLen; i++) {
                if (input.charAt(i) == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (front == rear) {
                        isError = true;
                        break;
                    }

                    if (isReversed) rear--;
                    else front++;
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append('[');

                if (!isReversed) {
                    for (int i = front + 1; i <= rear; i++) {
                        sb.append(arr[i]).append(',');
                    }
                } else {
                    for (int i = rear; i > front; i--) {
                        sb.append(arr[i]).append(',');
                    }
                }

                if (sb.charAt(sb.length() - 1) != '[') sb.replace(sb.length()-1, sb.length(), "]");
                else sb.append(']');

                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
