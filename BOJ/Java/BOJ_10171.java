import java.io.*;

public class BOJ_10171 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("\\    /\\" + "\n")
                .append(" )  ( ')" + "\n")
                .append("(  /  )" + "\n")
                .append(" \\(__)|\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
