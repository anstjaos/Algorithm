import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    private static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) return this.end - o.end;

            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].start) {
                pq.poll();
            }

            pq.add(arr[i].end);
        }

        System.out.println(pq.size());
    }
}
