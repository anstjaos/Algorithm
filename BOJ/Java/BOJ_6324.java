import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_6324 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int TC = Integer.parseInt(br.readLine());
        Matcher matcher;
        String regex = "(http|ftp|gopher)://([\\w.-]+)(?::([\\d]+))?(?:/([\\S]+))?";
        String[] arr = {"Protocol = ", "Host     = ", "Port     = ", "Path     = "};

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= TC; i++) {
            sb.append("URL #").append(i).append("\n");

            String input = br.readLine();
            matcher = Pattern.compile(regex).matcher(input);
            if(matcher.find()) {
                for(int j=1; j<=4; j++) {
                    if(matcher.group(j) != null) {
                        sb.append(arr[j-1] + matcher.group(j) + "\n");
                    } else {
                        sb.append(arr[j-1] + "<default>" + "\n");
                    }
                }
                sb.append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
