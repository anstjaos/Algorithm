import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2997 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];

        if (diff == diff2) System.out.println(arr[2] + diff);
        else if (diff > diff2) System.out.println(arr[0] + diff2);
        else System.out.println(arr[1] + diff);

    }
}
