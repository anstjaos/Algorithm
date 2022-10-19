import java.io.*;

public class BOJ_17863 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();

        if (input.startsWith("555")) System.out.println("YES");
        else System.out.println("NO");

        br.close();
    }
}
