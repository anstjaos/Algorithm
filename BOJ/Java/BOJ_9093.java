import java.io.*;

public class BOJ_9093 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            String[] arr = input.split(" ");

            for (int i = 0; i < arr.length; i++) {
                StringBuilder temp = new StringBuilder(arr[i]);
                sb.append(temp.reverse()).append(" ");
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
