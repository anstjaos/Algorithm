import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17388 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int soongsil = Integer.parseInt(st.nextToken());
        int korea = Integer.parseInt(st.nextToken());
        int hanyang = Integer.parseInt(st.nextToken());

        if (soongsil + korea + hanyang >= 100) System.out.println("OK");
        else {
            if (soongsil < korea && soongsil < hanyang) System.out.println("Soongsil");
            else if (korea < soongsil && korea < hanyang) System.out.println("Korea");
            else if (hanyang < soongsil && hanyang < korea) System.out.println("Hanyang");
        }
        br.close();
    }
}
