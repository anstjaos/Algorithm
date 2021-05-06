import java.io.*;

public class BOJ_2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        String[] map = new String[N];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";

        for (int k = 1; 3 * (int)Math.pow(2, k) <= N; ++k) {
            makeBigStar(k, map);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            sb.append(map[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void makeBigStar(int k, String[] map) {
        int bottom = 3 * (int)Math.pow(2, k);
        int middle = bottom / 2;

        for (int i = middle; i < bottom; ++i) {
            map[i] = map[i - middle] + " " + map[i -middle];
        }

        StringBuilder space = new StringBuilder();
        while (space.length() < middle) {
            space.append(" ");
        }
        for (int i = 0; i < middle; ++i) {
            map[i] = space + map[i] + space;
        }
    }

}
