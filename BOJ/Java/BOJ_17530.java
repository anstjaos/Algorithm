import java.io.*;

public class BOJ_17530 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int carlos = Integer.parseInt(br.readLine());

        int maxVote = carlos;
        for (int i = 0; i < N - 1; i++) {
            int num = Integer.parseInt(br.readLine());
            maxVote = Math.max(maxVote, num);
        }
        br.close();

        if (maxVote == carlos) System.out.println("S");
        else System.out.println("N");
    }
}
