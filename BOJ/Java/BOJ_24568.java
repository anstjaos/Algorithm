import java.io.*;

public class BOJ_24568 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int R = Integer.parseInt(br.readLine()), S = Integer.parseInt(br.readLine());

        int result = R * 8 + S * 3 - 28;
        if (result >= 0) System.out.println(result);
        else System.out.println(0);
        br.close();
    }
}
