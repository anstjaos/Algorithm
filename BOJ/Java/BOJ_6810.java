import java.io.*;

public class BOJ_6810 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine());
        br.close();

        System.out.println("The 1-3-sum is " + (91 + a + (b * 3) + c));
    }
}
