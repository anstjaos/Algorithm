import java.io.*;

public class BOJ_15680 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        if (N == 0) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");
    }
}
