import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int curWeight = 0, time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(arr[i]);
                    time++;
                    curWeight += arr[i];
                    break;
                } else if (queue.size() == w) {
                    curWeight -= queue.remove();
                } else {
                    if (curWeight + arr[i] > l) {
                        queue.add(0);
                        time++;
                    } else {
                        queue.add(arr[i]);
                        time++;
                        curWeight += arr[i];
                        break;
                    }
                }
            }
        }

        System.out.println(time + w);
    }
}
