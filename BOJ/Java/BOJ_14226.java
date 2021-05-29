import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {
    private static class Imoticon {
        int imoticonSize;
        int clipboardSize;
        int count;

        public Imoticon(int imoticonSize, int clipboardSize, int count) {
            this.imoticonSize = imoticonSize;
            this.clipboardSize = clipboardSize;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        br.close();

        int[][] visit = new int[2 * S + 1][2 * S + 1];
        for (int i = 0; i < 2 * S + 1; i++) Arrays.fill(visit[i], Integer.MAX_VALUE);

        Queue<Imoticon> queue = new LinkedList<>();
        queue.add(new Imoticon(1, 0, 0));
        visit[1][0] = 0;

        int result = 0;
        while (!queue.isEmpty()) {
            Imoticon cur = queue.poll();
            if (cur.imoticonSize == S) {
                result = cur.count;
                break;
            }

            queue.add(new Imoticon(cur.imoticonSize, cur.imoticonSize, cur.count + 1));

            int nextImoticonSize = cur.imoticonSize + cur.clipboardSize;
            int nextClipboardSize = cur.clipboardSize;
            if (cur.clipboardSize != 0 && nextImoticonSize <= S && visit[nextImoticonSize][nextClipboardSize] > cur.count + 1) {
                queue.add(new Imoticon(cur.imoticonSize + cur.clipboardSize, cur.clipboardSize, cur.count + 1));
                visit[nextImoticonSize][nextClipboardSize] = cur.count + 1;
            }

            nextImoticonSize = cur.imoticonSize - 1;
            nextClipboardSize = cur.clipboardSize;
            if (nextImoticonSize >= 0 && visit[nextImoticonSize][nextClipboardSize] > cur.count + 1) {
                queue.add(new Imoticon(cur.imoticonSize - 1, cur.clipboardSize, cur.count + 1));
                visit[nextImoticonSize][nextClipboardSize] = cur.count + 1;
            }
        }

        System.out.println(result);
    }
}
