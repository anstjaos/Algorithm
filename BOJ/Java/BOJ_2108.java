import java.io.*;
import java.util.Arrays;

public class BOJ_2108 {
    public static class NumberCount implements Comparable<NumberCount> {
        public int num;
        public int count;

        public NumberCount() {}
        public NumberCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(NumberCount o) {
            if (this.count == o.count) {
                return this.num - o.num;
            }

            return  o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[500005];
        int[] count = new int[9000];

        double sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;
        }

        NumberCount[] numberCounts = new NumberCount[500005];
        int numberCountsIndex = 0;
        for(int i = 0; i <= 8000; i++) {
            if (count[i] == 0) continue;

            numberCounts[numberCountsIndex++] = new NumberCount(i - 4000, count[i]);
        }
        Arrays.sort(arr, 0, N);
        Arrays.sort(numberCounts, 0, numberCountsIndex);
        int sumResult = (int) Math.round(sum / N);

        StringBuilder sb = new StringBuilder();
        sb.append(sumResult + "\n");
        sb.append(arr[N / 2] + "\n");

        if (numberCountsIndex > 1 && numberCounts[0].count == numberCounts[1].count) sb.append(numberCounts[1].num + "\n");
        else sb.append(numberCounts[0].num + "\n");

        sb.append(arr[N-1] - arr[0]);

        System.out.println(sb.toString());

        br.close();
    }
}
