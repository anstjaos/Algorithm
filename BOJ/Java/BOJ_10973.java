import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int index = N - 1;
        while (index > 0 && arr[index - 1] <= arr[index]) index--;

        if (index == 0) {
            System.out.println(-1);
            return;
        }

        int index2 = N - 1;
        while (arr[index-1] <= arr[index2]) index2--;

        int temp = arr[index2];
        arr[index2] = arr[index - 1];
        arr[index - 1] = temp;

        Arrays.sort(arr, index, N, (o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }
}
