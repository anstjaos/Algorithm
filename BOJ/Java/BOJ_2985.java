import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2985 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        br.close();
        for (int i = 0; i < 3;  i++) arr[i] = Integer.parseInt(st.nextToken());

        if (arr[0] + arr[1] == arr[2]) {
            System.out.println(arr[0] + "+" + arr[1] + "=" + arr[2]);
        } else if (arr[0] - arr[1] == arr[2]) {
            System.out.println(arr[0] + "-" + arr[1] + "=" + arr[2]);
        } else if (arr[0] * arr[1] == arr[2]) {
            System.out.println(arr[0] + "*" + arr[1] + "=" + arr[2]);
        } else if (arr[0] / arr[1] == arr[2]) {
            System.out.println(arr[0] + "/" + arr[1] + "=" + arr[2]);
        } else if (arr[0] == arr[1] + arr[2]) {
            System.out.println(arr[0] + "=" + arr[1] + "+" + arr[2]);
        } else if (arr[0] == arr[1] - arr[2]) {
            System.out.println(arr[0] + "=" + arr[1] + "-" + arr[2]);
        } else if (arr[0] == arr[1] * arr[2]) {
            System.out.println(arr[0] + "=" + arr[1] + "*" + arr[2]);
        } else if (arr[0] == arr[1] / arr[2]) {
            System.out.println(arr[0] + "=" + arr[1] + "/" + arr[2]);
        }
    }
}
