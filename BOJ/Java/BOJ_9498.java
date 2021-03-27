import java.io.*;

public class BOJ_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());

        char result;
        if (score >= 90) result = 'A';
        else if (score >= 80) result = 'B';
        else if (score >= 70) result = 'C';
        else if (score >= 60) result = 'D';
        else result = 'F';

        System.out.println(result);
        br.close();
    }
}
