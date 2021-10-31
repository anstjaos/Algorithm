import java.io.*;
import java.util.Arrays;

public class BOJ_2822 {
    private static class Problem implements Comparable<Problem> {
        int num, score;

        public Problem(int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Problem o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Problem[] problems = new Problem[8];

        for (int i = 1; i <= 8; i++) {
            problems[i - 1] = new Problem(i, Integer.parseInt(br.readLine()));
        }
        br.close();

        Arrays.sort(problems);
        int result = 0;
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = problems[i].num;
            result += problems[i].score;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        Arrays.sort(nums);
        for (int i = 0; i < 5; i++) sb.append(nums[i]).append(" ");
        System.out.println(sb);
    }
}
