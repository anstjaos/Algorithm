import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
    private static class Jewel implements Comparable<Jewel> {
        int weight, price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.weight == o.weight) {
                return o.price - this.price;
            }
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) bags[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> selected = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewels[j].weight <= bags[i]) {
                selected.offer(jewels[j++].price);
            }

            if (!selected.isEmpty()) result += selected.poll();
        }

        System.out.println(result);
    }
}
