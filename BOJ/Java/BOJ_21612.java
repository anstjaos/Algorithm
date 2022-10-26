import java.io.*;

public class BOJ_21612 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int B = Integer.parseInt(br.readLine());

        int sum = 5 * B - 400;
        System.out.println(sum);
        if (sum < 100) System.out.println(1);
        else if (sum > 100) System.out.println(-1);
        else System.out.println(0);
        br.close();
    }
}
