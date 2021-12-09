import java.io.*;

public class BOJ_4766 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        double cur = Double.parseDouble(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (true) {
            double before = cur;
            cur = Double.parseDouble(br.readLine());
            if (cur == 999) break;

            sb.append(String.format("%.2f", cur - before)).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
