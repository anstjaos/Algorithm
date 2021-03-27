import java.io.*;
import java.util.Arrays;

public class BOJ_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] arr = new int[30];
        Arrays.fill(arr, -1);
        int inputLen = input.length();

        for (int i = 0 ; i < inputLen; i++) {
            int index = input.charAt(i) - 'a';
            if (arr[index] == -1) arr[index] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 26; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
