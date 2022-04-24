import java.io.*;

public class BOJ_5555 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N-- > 0) {
            String input = br.readLine();
            input = input.repeat(2);

            if (input.contains(word)) count++;
        }
        br.close();
        System.out.println(count);
    }
}
