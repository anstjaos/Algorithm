import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int result = 0;

        if (arr[0] == arr[1] && arr[1] == arr[2]) result = 10000 + (arr[0] * 1000);
        else if (arr[0] == arr[1] || arr[1] == arr[2]) result = 1000 + (arr[1] * 100);
        else result = arr[2] * 100;

        System.out.println(result);
    }
}
