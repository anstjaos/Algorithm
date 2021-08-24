import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1755 {
    private static String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    private static class Numbers implements Comparable<Numbers> {
        int number;
        String numberStr;

        public Numbers(int number) {
            this.number = number;

            int[] arr = new int[5];
            int count = 0;
            while (number != 0) {
                arr[count++] = number % 10;
                number /= 10;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = count - 1; i >= 0; i--) {
                sb.append(numbers[arr[i]]).append(" ");
            }

            this.numberStr = sb.toString();
        }

        @Override
        public int compareTo(Numbers o) {
            return this.numberStr.compareTo(o.numberStr);
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        br.close();

        List<Numbers> numberList = new ArrayList<>();
        for (int i = M; i<= N; i++) {
            numberList.add(new Numbers(i));
        }

        Collections.sort(numberList);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (Numbers number : numberList) {
            count++;
            sb.append(number.number).append(" ");

            if (count % 10 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}
