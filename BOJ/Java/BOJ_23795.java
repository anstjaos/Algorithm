import java.io.*;

public class BOJ_23795 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int sum = 0;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            sum += num;
        }
        br.close();
        System.out.println(sum);
    }
}
