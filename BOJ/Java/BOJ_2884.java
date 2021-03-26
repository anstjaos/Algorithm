import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute - 45 < 0) {
            hour = (hour - 1 + 24) % 24;
            minute = (minute - 45 + 60) % 60;
        } else {
            minute = (minute - 45 + 60) % 60;
        }

        System.out.println(hour + " " + minute);
        br.close();
    }
}
