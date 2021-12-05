import java.io.*;

public class BOJ_3053 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Double r = Double.parseDouble(br.readLine());
        br.close();

        System.out.println(r * r * Math.PI);
        System.out.println(2 * r * r);
    }
}
