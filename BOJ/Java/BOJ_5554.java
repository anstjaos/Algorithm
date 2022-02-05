import java.io.*;

public class BOJ_5554 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int totalSec = 0;

        for (int i = 0; i < 4; i++) {
            totalSec += Integer.parseInt(br.readLine());
        }
        br.close();

        System.out.println(totalSec / 60);
        System.out.println(totalSec % 60);
    }
}
