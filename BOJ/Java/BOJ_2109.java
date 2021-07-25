import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109 {
    private static class Lecture implements Comparable<Lecture> {
        int day, pay;

        public Lecture(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.pay == o.pay) return this.day - o.day;
            return o.pay - this.pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq = new PriorityQueue<>();

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxDay = Math.max(d, maxDay);
            pq.add(new Lecture(d, p));
        }
        br.close();

        boolean[] isChecked = new boolean[maxDay + 1];
        int result = 0;

        while (!pq.isEmpty()) {
            Lecture cur = pq.poll();

            for (int i = cur.day; i >= 1; i--) {
                if (!isChecked[i]) {
                    isChecked[i] = true;
                    result += cur.pay;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
