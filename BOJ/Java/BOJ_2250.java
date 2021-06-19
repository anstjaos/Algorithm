import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2250 {
    private static class Node {
        int num, parent, left, right;

        public Node(int num, int parent, int left, int right) {
            this.num = num;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private static Node[] nodes;
    private static int N, maxLevel, visitCount;
    private static int[] levelMinIndex, levelMaxIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N+1];
        levelMinIndex = new int[N+1];
        levelMaxIndex = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, -1, -1, -1);
            levelMinIndex[i] = N;
            levelMaxIndex[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken()), left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
            nodes[cur].left = left;
            nodes[cur].right = right;
            if (left != -1) nodes[left].parent = cur;
            if (right != -1) nodes[right].parent = cur;
        }
        br.close();

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (nodes[i].parent == -1) {
                root = i;
                break;
            }
        }

        maxLevel = 0;
        visitCount = 1;

        inOrder(root, 1);

        int levelResult = 1;
        int widthResult = levelMaxIndex[1] - levelMinIndex[1] + 1;
        for (int i = 2; i <= maxLevel; i++) {
            int width = levelMaxIndex[i] - levelMinIndex[i] + 1;
            if (width > widthResult) {
                widthResult = width;
                levelResult = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(levelResult).append(" ").append(widthResult);
        System.out.println(sb);
    }

    private static void inOrder(int cur, int level) {
        if (maxLevel < level) maxLevel = level;

        if (nodes[cur].left != -1) inOrder(nodes[cur].left, level + 1);

        levelMinIndex[level] = Math.min(levelMinIndex[level], visitCount);
        levelMaxIndex[level] = visitCount;
        visitCount++;

        if (nodes[cur].right != -1) inOrder(nodes[cur].right, level + 1);
    }
}
