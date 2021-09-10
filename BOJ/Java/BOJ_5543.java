import java.io.*;

public class BOJ_5543 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int minBurger = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            minBurger = Math.min(minBurger, Integer.parseInt(br.readLine()));
        }

        int minDrink = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) minDrink = Math.min(minDrink, Integer.parseInt(br.readLine()));

        br.close();

        System.out.println(minBurger + minDrink - 50);
    }
}
