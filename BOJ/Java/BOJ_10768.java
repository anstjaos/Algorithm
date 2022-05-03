import java.io.*;

public class BOJ_10768 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int month = Integer.parseInt(br.readLine()), day = Integer.parseInt(br.readLine());
        br.close();

        if ((month <= 2 && day < 18) || month < 2) {
            System.out.println("Before");
        } else if ((month == 2 && day > 18) || month >= 3) {
            System.out.println("After");
        } else if (month == 2 && day == 18) {
            System.out.println("Special");
        }
    }
}
