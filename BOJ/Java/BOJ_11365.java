import java.io.*;

public class BOJ_11365 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("END")) break;

            StringBuilder temp = new StringBuilder(input);
            sb.append(temp.reverse()).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
