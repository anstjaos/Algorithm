import java.io.*;

public class BOJ_18108 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int year = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(year - 543);
    }
}
