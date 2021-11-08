import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5073 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            Arrays.sort(arr);

            if (arr[2] >= (arr[0] + arr[1])) sb.append("Invalid\n");
            else if (arr[0] == arr[1] && arr[0] == arr[2]) sb.append("Equilateral\n");
            else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) sb.append("Isosceles\n");
            else if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) sb.append("Scalene\n");
        }
        br.close();
        System.out.print(sb);
    }
}
