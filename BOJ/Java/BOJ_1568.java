import java.io.*;

public class BOJ_1568 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int sec = 0;
        int N = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        while (N > 0) {
            sec++;
            count++;
            if (N - sec < 0) sec = 1;
            N -= sec;
        }

        System.out.println(count);
    }
}
