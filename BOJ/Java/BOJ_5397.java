import java.io.*;

public class BOJ_5397 {
    private static class Key {
        char c;
        Key pre, next;

        public Key(char c, Key pre, Key next) {
            this.c = c;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            Key head = new Key('4', null, null);
            Key curKey = head;

            String input = br.readLine();
            int length = input.length();
            for (int i = 0; i < length; i++) {
                char cur = input.charAt(i);
                if (cur == '<') {
                    if (curKey == head) continue;
                    curKey = curKey.pre;
                } else if (cur == '>') {
                    if (curKey.next == null) continue;
                    curKey = curKey.next;
                } else if (cur == '-') {
                    if (curKey == head) continue;
                    curKey.pre.next = curKey.next;
                    if (curKey.next != null) {
                        curKey.next.pre = curKey.pre;
                    }
                    curKey = curKey.pre;
                } else {
                    Key newKey = new Key(cur, curKey, curKey.next);
                    if (curKey.next != null) curKey.next.pre = newKey;
                    curKey.next = newKey;

                    curKey = newKey;
                }
            }

            curKey = head.next;
            while (curKey != null) {
                sb.append(curKey.c);
                curKey = curKey.next;
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
