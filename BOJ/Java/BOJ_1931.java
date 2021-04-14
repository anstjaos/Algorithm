import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    private static class ConfRoom implements Comparable<ConfRoom> {
        int start;
        int end;

        public ConfRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ConfRoom o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ConfRoom[] arr = new ConfRoom[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new ConfRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int end = arr[0].end, result = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i].start < end) continue;

            end = arr[i].end;
            result++;
        }

        System.out.println(result);
        br.close();
    }
}
