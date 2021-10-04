import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10093 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
        if(a>b) {
            sb.append(a-b-1).append("\n");
            for(long i=b+1;i<a;i++) {
                sb.append(i).append(" ");
            }
        }
        if(b>a) {
           sb.append(b-a-1).append("\n");
            for(long i=a+1;i<b;i++) {
                sb.append(i).append(" ");
            }
        }
        if(a==b) {
            sb.append(0);
        }

        System.out.println(sb);
    }
}
