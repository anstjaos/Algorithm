import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4256 {
    private static int size;
    private static int[] preOrder, inOrder;
    private static boolean[] isVisit;
    private static StringBuilder sb;
    private static class Node {
        int num;
        Node left, right;

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (tc-- > 0) {
            size = Integer.parseInt(br.readLine());
            preOrder = new int[size];
            inOrder = new int[size];
            isVisit = new boolean[size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }

            Node root = new Node(preOrder[0], null, null);
            isVisit[0] = true;
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (inOrder[i] == root.num) {
                    index = i;
                    break;
                }
            }
            root.left = find(0, index);
            root.right = find(index + 1, size);

            getResult(root);
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static Node find(int start, int end) {
        if (start >= end) return null;

        int val = 0;
        for (int i = 0; i < size; i++) {
            if (!isVisit[i]) {
                val = preOrder[i];
                isVisit[i] = true;
                break;
            }
        }
        if (val == 0) return null;

        int index = -1;
        for (int i = start; i < end; i++) {
            if (inOrder[i] == val) {
                index = i;
                break;
            }
        }

        Node cur = new Node(val, null, null);
        cur.left = find(start, index);
        cur.right = find(index + 1, end);
        return cur;
    }

    private static void getResult(Node cur) {
        if (cur == null) return;
        getResult(cur.left);
        getResult(cur.right);
        sb.append(cur.num).append(" ");
    }
}
