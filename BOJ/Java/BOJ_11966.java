import java.io.*;

public class BOJ_11966 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        boolean isSquare = true;
        while (N != 1) {
            if (N % 2 == 1) {
                isSquare = false;
                break;
            }
            N /= 2;
        }

        System.out.println(isSquare ? 1 : 0);
    }
}
