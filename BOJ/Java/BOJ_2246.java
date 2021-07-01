import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2246 {
    private static class CondoSortByDistance implements Comparable<CondoSortByDistance> {
        int index, distance, cost;

        public CondoSortByDistance(int index, int distance, int cost) {
            this.index = index;
            this.distance = distance;
            this.cost = cost;
        }

        @Override
        public int compareTo(CondoSortByDistance o) {
            if (this.distance == o.distance) {
                return this.cost - o.cost;
            }
            return this.distance - o.distance;
        }
    }

    private static class CondoSortByCost implements  Comparable<CondoSortByCost> {
        int index, distance, cost;

        public CondoSortByCost(int index, int distance, int cost) {
            this.index = index;
            this.distance = distance;
            this.cost = cost;
        }

        @Override
        public int compareTo(CondoSortByCost o) {
            if (this.cost == o.cost) {
                return this.distance - o.distance;
            }

            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CondoSortByDistance[] distances = new CondoSortByDistance[N];
        CondoSortByCost[] costs = new CondoSortByCost[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
            distances[i] = new CondoSortByDistance(i, distance, cost);
            costs[i] = new CondoSortByCost(i, distance, cost);
        }
        br.close();

        Arrays.sort(distances);
        Arrays.sort(costs);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int index = 0;
            for (; index < N; index++) {
                if (distances[index].index == i) break;
            }

            boolean isSuccess = true;
            CondoSortByDistance condo = distances[index];

            for (int j = index - 1; j >= 0; j--) {
                if (distances[j].cost <= condo.cost) {
                    isSuccess = false;
                    break;
                }
            }

            if (!isSuccess) continue;

            index = 0;
            for (; index < N; index++) {
                if (costs[index].index == i) break;
            }

            for (int j = index - 1; j >= 0; j--) {
                if (costs[j].distance <= condo.distance) {
                    isSuccess = false;
                    break;
                }
            }

            if (isSuccess) result++;
        }

        System.out.println(result);
    }
}
