import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17256 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aX = Integer.parseInt(st.nextToken()), aY = Integer.parseInt(st.nextToken()), aZ = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cX = Integer.parseInt(st.nextToken()), cY = Integer.parseInt(st.nextToken()), cZ = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println((cX - aZ) + " " + (cY / aY) + " " + (cZ - aX));
    }
}
