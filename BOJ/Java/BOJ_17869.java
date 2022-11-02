import java.io.*;

public class BOJ_17869 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        long n = Long.parseLong(br.readLine());

        int count = 0;
        while (n != 1) {
            if (n % 2 == 1) n++;
            else n /= 2;
            count++;
        }
        br.close();
        System.out.println(count);
    }
}
