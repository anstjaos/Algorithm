import java.io.*;

public class BOJ_10707 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        br.close();

        int xCompany = P * A;
        int yCompany = 0;

        if (P <= C) yCompany = B;
        else yCompany = B + ((P - C) * D);

        System.out.println(Math.min(xCompany, yCompany));
    }
}
