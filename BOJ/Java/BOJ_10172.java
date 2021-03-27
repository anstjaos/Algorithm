import java.io.*;

public class BOJ_10172 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("|\\_/|\n")
                .append("|q p|   /}\n")
                .append("( 0 )\"\"\"\\\n")
                .append("|\"^\"`    |\n")
                .append("||_/=\\\\__|\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
