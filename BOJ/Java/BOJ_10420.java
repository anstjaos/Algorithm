import java.io.*;
import java.time.LocalDate;

public class BOJ_10420 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        LocalDate cur = LocalDate.of(2014, 4, 1);
        System.out.println(cur.plusDays(N));
    }
}
