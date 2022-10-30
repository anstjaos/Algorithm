import java.io.*;
import java.util.StringTokenizer;

public class BOJ_22938 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double r = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());

        if ((x-x1)*(x-x1)+(y-y1)*(y-y1) < (r+r1)*(r+r1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }
}
