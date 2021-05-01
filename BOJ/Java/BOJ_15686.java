import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15686 {
    private static int N, M;
    private static List<House> house, chickens;
    private static Stack<House> selectedChickens;
    private static int result = Integer.MAX_VALUE;

    private static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chickens = new ArrayList<>();
        selectedChickens = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    house.add(new House(i, j));
                } else if (num == 2) {
                    chickens.add(new House(i, j));
                }
            }
        }

        dfs(0, 0);
        br.close();

        System.out.println(result);
    }

    private static void dfs(int start, int count) {
        if (count == M) {
            bfs();
            return;
        }

        int chickenSize = chickens.size();
        for (int i = start; i < chickenSize; i++) {
            selectedChickens.add(chickens.get(i));
            dfs(i + 1, count + 1);
            selectedChickens.pop();
        }
    }

    private static void bfs() {
        int sum = 0;

        for (House house : house) {
            int min = Integer.MAX_VALUE;
            for (House chicken : selectedChickens) {
                int dist = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
                min = Math.min(min, dist);
            }

            sum += min;

            if (sum >= result) {
                return;
            }
        }

        result = sum;
    }
}
