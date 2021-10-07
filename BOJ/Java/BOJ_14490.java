import java.io.*;

public class BOJ_14490 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        String[] split = input.split(":");

        int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
        br.close();

        int gcd = gcd(n, m);

        System.out.println((n / gcd) + ":" + (m /gcd));
    }

    private static int gcd(int a, int b) {
        int mod = a % b;
        while (mod > 0) {
            a = b;
            b = mod;
            mod = a % b;
        }
        return b;
    }
}
