import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int index = N - 1;
        while (index != 0) {
            if (arr[index] > arr[index-1]) {
                break;
            }
            index--;
        }

        if (index == 0) {
            System.out.println(-1);
            return;
        }

        int index2 = N - 1;
        while(arr[index-1] >= arr[index2]) index2--;

        int tmp = arr[index-1];
        arr[index-1] = arr[index2];
        arr[index2] = tmp;

        int start = index;
        int end = N - 1;
        while(start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(arr[i]).append(" ");

        System.out.println(sb);
    }
}
