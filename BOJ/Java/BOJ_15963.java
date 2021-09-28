import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15963 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        System.out.println(st.nextToken().equals(st.nextToken()) ? 1 : 0);
    }
}
