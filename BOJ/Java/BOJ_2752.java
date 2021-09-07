import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2752 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }
}
