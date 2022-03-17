import java.io.*;
import java.util.Arrays;

public class BOJ_11948 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] arr = new int[4];
        int[] arr1 = new int[2];

        for (int i = 0; i < 4; i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2; i++) arr1[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        Arrays.sort(arr1);

        int result = arr1[1];
        for (int i = 1; i < 4; i++) result += arr[i];

        System.out.println(result);
    }
}
