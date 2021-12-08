import java.io.*;

public class BOJ_9657 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        System.out.println((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
    }
}
