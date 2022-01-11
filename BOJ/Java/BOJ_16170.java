import java.io.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class BOJ_16170 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        Date date = Date.from(utc.toInstant());
        StringBuilder sb = new StringBuilder();

        sb.append(1900 + date.getYear()).append("\n")
                .append(String.format("%02d", date.getMonth() + 1)).append("\n")
                .append(date.getDate()).append("\n");

        System.out.print(sb);
    }
}
