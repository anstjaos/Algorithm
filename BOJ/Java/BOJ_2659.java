import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isVisit = new boolean[10001];
        List<Integer> clockNumber = new ArrayList<>();
        for (int i = 1111; i <= 9999; i++) {
            if (isVisit[i]) continue;

            int minNum = i;
            int num = i;
            for (int j = 0; j < 3; j++) {
                int temp = num % 1000;
                num = (temp * 10) + (num / 1000);
                minNum = Math.min(minNum, num);
            }

            if (minNum == i) {
                clockNumber.add(i);
                isVisit[i] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = (Integer.parseInt(st.nextToken()) * 1000) + (Integer.parseInt(st.nextToken()) * 100) + (Integer.parseInt(st.nextToken()) * 10) + Integer.parseInt(st.nextToken());
        br.close();

        int minNum = num;
        for (int i = 0; i < 4; i++) {
            int temp = num % 1000;
            num = (temp * 10) + (num / 1000);
            minNum = Math.min(minNum, num);
        }

        Collections.sort(clockNumber);
        int count = 0;
        for (Integer clock : clockNumber) {
            count++;
            if (clock == minNum) break;
        }

        System.out.println(count);
    }
}
