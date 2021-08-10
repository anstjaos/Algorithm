import java.io.*;

public class BOJ_11648 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        int temp = N;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int result = 0;
        while (count > 1) {
            count = 0;
            temp = 1;
            while (N != 0) {
                temp *= (N % 10);
                N /= 10;
                count++;
            }

            N = temp;
            if (count > 1) result++;
        }

        System.out.println(result);
    }
}
