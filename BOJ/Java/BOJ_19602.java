import java.io.*;

public class BOJ_19602 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int S = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), L = Integer.parseInt(br.readLine());

        if (S + 2 * M + 3 * L >= 10) System.out.println("happy");
        else System.out.println("sad");
        br.close();
    }
}
