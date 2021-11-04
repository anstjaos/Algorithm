import java.io.*;

public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        int plus = 1;
        int num = 10;

        for(int i=1; i<=N; i++) {
            if(i % num == 0) {
                plus ++;
                num *= 10;
            }
            count += plus;

        }
        System.out.println(count);
    }
}
