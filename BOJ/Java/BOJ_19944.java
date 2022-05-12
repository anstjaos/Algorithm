import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19944 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        String result = "";
        br.close();

        if (M == 1 || M == 2) result = "NEWBIE!";
        else if (M <= N) result = "OLDBIE!";
        else result = "TLE!";

        System.out.println(result);
    }
}
