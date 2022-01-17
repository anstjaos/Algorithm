import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941 {
    private static char[][] map = new char[5][5];
    private static int result;
    private static int[] sel = new int [7];

    private static void comb(int idx ,int selidx,int Y) {
        if(Y>3)
            return;
        if(selidx == 7) {
            if(check()) {
                result++;
            }
            return;
        }
        if(idx == 25)
            return;

        sel[selidx] = idx;
        int isY = map[idx/5][idx%5] == 'Y'? 1 : 0;
        comb(idx+1,selidx+1,Y+isY);
        comb(idx+1,selidx,Y);
    }

    private static boolean check() {
        boolean [] visit = new boolean [7];
        visit[0] =true;
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(0);
        int cnt = 1;
        while(!que.isEmpty()) {
            int i = que.poll();
            for(int j = 0 ; j < 7 ; j++) {
                if(i==j || visit[j])
                    continue;
                if(sel[i] % 5 == 0) // 가장 왼쪽 벽일때
                    if(sel[i] - 1 == sel[j])
                        continue;
                if(sel[i] % 5 == 4) //가장 오른쪽 벽일때
                    if(sel[i] + 1 == sel[j])
                        continue;
                if(sel[i] - 1 == sel[j] || sel[i] + 1 == sel[j] || sel[i]+5 == sel[j] || sel[i] - 5 == sel[j]) {
                    que.offer(j);
                    visit[j] = true;
                    cnt++;
                }
            }
        }
        if (cnt != 7) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        comb(0,0,0);
        System.out.println(result);

    }
}
