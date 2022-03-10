import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14469 {
    private static class Cow implements Comparable<Cow> {
        int arrivedTime, time;

        public Cow(int arrivedTime, int time) {
            this.arrivedTime = arrivedTime;
            this.time = time;
        }

        @Override
        public int compareTo(Cow o) {
            if (this.arrivedTime == o.arrivedTime) return this.time - o.time;
            return this.arrivedTime - o.arrivedTime;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cows);
        br.close();

        int curTime = cows[0].arrivedTime + cows[0].time;
        for (int i = 1; i < N; i++) {
            curTime = Math.max(curTime, cows[i].arrivedTime);
            curTime += cows[i].time;
        }

        System.out.println(curTime);
    }
}
