import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            bubbleSort(arr, 0, 2);
            if ((arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void bubbleSort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            for(int j = i + 1; j <= end; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
