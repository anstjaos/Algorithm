import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1924 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayStr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int month = Integer.parseInt(st.nextToken()), day = Integer.parseInt(st.nextToken());

        int days = 0;
        for (int i = 1; i < month; i++) days += months[i];

        days += day;
        System.out.println(dayStr[days % 7]);
    }
}
