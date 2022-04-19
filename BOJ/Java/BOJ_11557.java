import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11557 {
    private static class College implements Comparable<College> {
        String name;
        int count;

        public College(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(College o) {
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            College[] colleges = new College[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                colleges[i] = new College(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(colleges);
            sb.append(colleges[0].name).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
