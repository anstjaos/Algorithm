import java.io.*;

public class BOJ_14581 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String id = br.readLine();
        br.close();
        StringBuilder sb = new StringBuilder();
        sb.append(":fan::fan::fan:\n")
                .append(":fan::").append(id).append("::fan:\n")
                .append(":fan::fan::fan:\n");

        System.out.print(sb);
    }
}
