import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3047 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = input.charAt(i) - 'A';
            sb.append(arr[index]).append(" ");
        }
        br.close();
        System.out.println(sb);
    }
}
