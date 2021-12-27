import java.io.*;

public class BOJ_2089 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        if (N == 0) sb.append(0);
        else {
            while (N != 1) {
                sb.append(Math.abs(N % -2));
                N = (int) Math.ceil((double) N / (-2));
            }
            sb.append(N);
        }
        System.out.println(sb.reverse());
    }
}
