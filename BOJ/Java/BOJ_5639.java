import java.io.*;

public class BOJ_5639 {
    private static class Node {
        Node parent;
        int cur;
        Node left;
        Node right;

        public Node(Node parent, int cur, Node left, Node right) {
            this.parent = parent;
            this.cur = cur;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node left) { this.left = left; }
        public void setRight(Node right) { this.right = right; }
    }

    private static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = null;

        String input = "";

        while ((input = br.readLine()) != null && input.length() != 0) {
            int num = Integer.parseInt(input);

            if (root == null) {
                root = new Node(null, num, null, null);
                continue;
            }

            Node cur = new Node(null, num, null, null);
            input(root, cur);
        }

        StringBuilder sb = new StringBuilder();
        suffixSearch(root, sb);
        System.out.print(sb);
        br.close();
    }

    private static void input(Node parent, Node cur) {
        if (cur.cur < parent.cur) {
            if (parent.left == null) {
                parent.left = cur;
                cur.parent = parent;
            } else {
                input(parent.left, cur);
            }
        } else {
            if (parent.right == null) {
                parent.right = cur;
                cur.parent = parent;
            } else {
                input(parent.right, cur);
            }
        }
    }

    private static void suffixSearch(Node cur, StringBuilder sb) {
        if (cur.left != null) suffixSearch(cur.left, sb);
        if (cur.right != null) suffixSearch(cur.right, sb);
        sb.append(cur.cur).append("\n");
    }
}
