import java.io.*;

public class BOJ_6778 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int antenna = Integer.parseInt(br.readLine()), eyes = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        if (antenna >= 3 && eyes <= 4) {
            sb.append("TroyMartian\n");
        }
        if (antenna <= 6 && eyes >= 2) {
            sb.append("VladSaturnian\n");
        }
        if (antenna <= 2 && eyes <= 3) {
            sb.append("GraemeMercurian\n");
        }

        System.out.print(sb);
    }
}
