import java.io.*;

public class BOJ_16561 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int sum = 1;
        int count = 2;

        for (int i = 9; i < n; i+= 3){
            sum += count;
            count += 1;
        }

        System.out.println(sum);
    }
}
