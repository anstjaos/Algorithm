import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14918 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        br.close();
    }
}
