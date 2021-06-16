import java.io.*;

public class BOJ_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String possible = br.readLine();
        String doctor = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        if (possible.length() >= doctor.length()) sb.append("go").append("\n");
        else sb.append("no").append("\n");

        System.out.print(sb);
    }
}
