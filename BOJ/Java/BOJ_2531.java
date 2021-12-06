import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] totalSushi = new int[d + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int startIdx = 0, endIdx = k - 1;
        int maxVal = 0, totalCount = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            if (totalSushi[sushi[i]] == 0) totalCount++;
            totalSushi[sushi[i]]++;
        }

        if (totalSushi[c] == 0) totalCount++;
        totalSushi[c]++;
        maxVal = totalCount;

        while (true) {
            totalSushi[sushi[startIdx]]--;
            if (totalSushi[sushi[startIdx]] == 0) totalCount--;
            startIdx = (startIdx + 1) % N;

            endIdx = (endIdx + 1) % N;
            if (totalSushi[sushi[endIdx]] == 0) totalCount++;
            totalSushi[sushi[endIdx]]++;

            maxVal = Math.max(maxVal, totalCount);

            if (startIdx == 0) break;
        }

        System.out.println(maxVal);
    }
}
