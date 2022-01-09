import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class BOJ_2948 {
    private static String[] dayOfWeek = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int day = Integer.parseInt(st.nextToken()), month = Integer.parseInt(st.nextToken());

        LocalDate date = LocalDate.of(2009, month, day);
        System.out.println(dayOfWeek[date.getDayOfWeek().getValue()]);
    }
}
