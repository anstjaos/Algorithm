import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22966 {
    private static class Problem implements Comparable<Problem> {
        String name;
        int diff;

        public Problem(String name, int diff) {
            this.name = name;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            return this.diff - o.diff;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(problems);
        br.close();
        System.out.println(problems[0].name);
    }
}
