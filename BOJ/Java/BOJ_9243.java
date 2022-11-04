import java.io.*;

public class BOJ_9243 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        String before = br.readLine(), after = br.readLine();

        if (N % 2 == 1) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < before.length(); i++) {
                if (before.charAt(i) == '0') temp.append('1');
                else temp.append('0');
            }

            before = temp.toString();
        }
        boolean result = before.equals(after);

        if (result) System.out.println("Deletion succeeded");
        else System.out.println("Deletion failed");
        br.close();
    }
}
