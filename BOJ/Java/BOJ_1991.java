import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991 {
    private static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            char parent = input.charAt(0);
            char left = input.charAt(2);
            char right = input.charAt(4);

            if (left != '.') tree[parent - 'A'][0] = left - 'A';
            if (right != '.') tree[parent - 'A'][1] = right - 'A';
        }

        StringBuilder sb = new StringBuilder();
        prefixSearch(sb, 0);
        sb.append("\n");
        middleSearch(sb, 0);
        sb.append("\n");
        suffixSearch(sb, 0);
        sb.append("\n");

        System.out.print(sb);
        br.close();
    }

    private static void prefixSearch(StringBuilder sb, int cur) {
        sb.append((char) ('A' + cur));
        if (tree[cur][0] != 0) prefixSearch(sb, tree[cur][0]);
        if (tree[cur][1] != 0) prefixSearch(sb, tree[cur][1]);
    }

    private static void middleSearch(StringBuilder sb, int cur) {
        if (tree[cur][0] != 0) middleSearch(sb, tree[cur][0]);
        sb.append((char) ('A' + cur));
        if (tree[cur][1] != 0) middleSearch(sb, tree[cur][1]);
    }

    private static void suffixSearch(StringBuilder sb, int cur) {
        if (tree[cur][0] != 0) suffixSearch(sb, tree[cur][0]);
        if (tree[cur][1] != 0) suffixSearch(sb, tree[cur][1]);
        sb.append((char) ('A' + cur));
    }
}
