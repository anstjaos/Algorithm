import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18868 {
    private static int M, N, map[][];

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int result = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (isSame(map[i], map[j])) result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr1[i] > arr1[j]) {
                    if (arr2[i] <= arr2[j]) return false;
                } else if (arr1[i] < arr1[j]) {
                    if (arr2[i] >= arr2[j]) return false;
                } else {
                    if (arr2[i] != arr2[j]) return false;
                }
            }
        }
        return true;
    }
}
