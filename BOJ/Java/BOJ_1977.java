import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());
        br.close();

        List<Integer> squareNum = new ArrayList<>();
        for (int i = 1; i < 105; i++) {
            squareNum.add(i * i);
        }

        long result = 0;
        int minNum = Integer.MAX_VALUE;
        for (Integer num : squareNum) {
            if (num > N) break;
            if (num < M) continue;

            result += num;
            minNum = Math.min(minNum, num);
        }

        StringBuilder sb = new StringBuilder();

        if (result == 0) sb.append(-1);
        else sb.append(result).append("\n").append(minNum);

        System.out.println(sb);
    }
}
