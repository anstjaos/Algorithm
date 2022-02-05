import java.io.*;

public class BOJ_6749 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(b + (b - a));
    }
}
