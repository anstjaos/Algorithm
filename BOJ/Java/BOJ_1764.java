import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        String[] noHear = new String[N];
        for (int i = 0; i < N; i++) {
            noHear[i] = br.readLine();
        }

        String[] noSee = new String[M];
        for (int i = 0; i < M; i++) {
            noSee[i] = br.readLine();
        }

        Arrays.sort(noHear);
        Arrays.sort(noSee);

        int leftIndex = 0, rightIndex = 0;

        int count = 0;
        String[] result = new String[N+M];
        while (leftIndex < N && rightIndex < M) {
            int compare = noHear[leftIndex].compareTo(noSee[rightIndex]);

            if (compare < 0) leftIndex++;
            else if (compare > 0) rightIndex++;
            else {
                result[count++] = noHear[leftIndex];
                leftIndex++;
                rightIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int i = 0; i < count; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
