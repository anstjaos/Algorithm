import java.io.*;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int money = 1000 - N;
        int count = 0;

        count += (money / 500);
        money -= (money / 500) * 500;

        count += (money / 100);
        money -= (money / 100) * 100;

        count += (money / 50);
        money -= (money / 50) * 50;

        count += (money / 10);
        money -= (money / 10) * 10;

        count += (money / 5);
        money -= (money / 5) * 5;

        count += money;

        System.out.println(count);
    }
}
