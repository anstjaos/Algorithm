import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2564 {
    private static class Store {
        int dir, dist;

        public Store(int dir, int dist) {
            this.dir = dir;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken()), height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        Store[] stores = new Store[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Store security = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        br.close();

        int result = 0;
        if (security.dir == 1) {
            for (int i = 0; i < N; i++) {
                Store curStore = stores[i];

                if (curStore.dir == 1) {
                    result += Math.abs(security.dist - curStore.dist);
                } else if (curStore.dir == 2) {
                    result += (height + Math.min(security.dist + curStore.dist, width * 2 - security.dist - curStore.dist));
                } else if (curStore.dir == 3) {
                    result += security.dist + curStore.dist;
                } else if (curStore.dir == 4) {
                    result += width - security.dist + curStore.dist;
                }
            }
        } else if (security.dir == 2) {
            for (int i = 0; i < N; i++) {
                Store curStore = stores[i];

                if (curStore.dir == 1) {
                    result += (height + Math.min(security.dist + curStore.dist, width * 2 - security.dist - curStore.dist));
                } else if (curStore.dir == 2) {
                    result += Math.abs(security.dist - curStore.dist);
                } else if (curStore.dir == 3) {
                    result += security.dist + height - curStore.dist;
                } else if (curStore.dir == 4) {
                    result += width - security.dist + height - curStore.dist;
                }
            }
        } else if (security.dir == 3) {
            for (int i = 0; i < N; i++) {
                Store curStore = stores[i];

                if (curStore.dir == 1) {
                    result += security.dist + curStore.dist;
                } else if (curStore.dir == 2) {
                    result += height - security.dist + curStore.dist;
                } else if (curStore.dir == 3) {
                    result += Math.abs(security.dist - curStore.dist);
                } else if (curStore.dir == 4) {
                    result += (width + Math.min(security.dist + curStore.dist, height * 2 - security.dist - curStore.dist));
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                Store curStore = stores[i];

                if (curStore.dir == 1) {
                    result += security.dist + width - curStore.dist;
                } else if (curStore.dir == 2) {
                    result += height - security.dist + width - curStore.dist;
                } else if (curStore.dir == 3) {
                    result += (width + Math.min(security.dist + curStore.dist, height * 2 - security.dist - curStore.dist));
                } else if (curStore.dir == 4) {
                    result += Math.abs(security.dist - curStore.dist);
                }
            }
        }

        System.out.println(result);
    }
}
