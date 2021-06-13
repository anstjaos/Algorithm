import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2357 {
    private static Node[] arr;
    private static int size;
    private static class Node {
        int min, max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        size = 1;
        while (size < N) {
            size = (size << 1);
        }
        arr = new Node[size * 2];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[size + i] = new Node(num, num);
        }
        for (int i = N; i < size; i++) {
            arr[size + i] = new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        int temp = size / 2;
        while (temp != 0) {
            for (int i = 0; i < temp; i++) {
                int next = temp + i;
                arr[next] = new Node(Math.min(arr[next*2].min, arr[next*2+1].min), Math.max(arr[next*2].max, arr[next*2+1].max));
            }
            temp /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Node n = getResult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1, size, 1);
            sb.append(n.min).append(" ").append(n.max).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static Node getResult(int left, int right, int curLeft, int curRight, int index) {
        if (curLeft >= left && curRight <= right) return arr[index];
        if (curLeft > right || curRight < left) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);

        int mid = (curLeft + curRight) / 2;

        Node leftNode = getResult(left, right, curLeft, mid, index * 2);
        Node rightNode = getResult(left, right, mid + 1, curRight, index * 2 + 1);
        return new Node(Math.min(leftNode.min, rightNode.min), Math.max(leftNode.max, rightNode.max));
    }
}
