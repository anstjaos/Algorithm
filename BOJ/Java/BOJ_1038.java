import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1038 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        if(N > 1022) {
            System.out.println(-1);
        } else if (N < 10) {
            System.out.println(N);
        } else {
            Queue<Long> q = new LinkedList<>();

            int cnt= 0;
            for(int i = 1; i<10; i++) {
                q.add((long) i); cnt++;
            }

            while(cnt< N) {
                long k = q.poll();
                long temp = k % 10;

                for(int i = 0; i<temp; i++) {
                    q.add(k*10 + i);
                    cnt++;

                    if(cnt == N) {
                        System.out.println(k*10+i); break;
                    }
                }
            }
        }

    }
}
