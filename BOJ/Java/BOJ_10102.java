import java.io.*;

public class BOJ_10102 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int V = Integer.parseInt(br.readLine());
        String input = br.readLine();
        br.close();

        int aCount = 0, bCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A') aCount++;
            else if (input.charAt(i) == 'B') bCount++;
        }

        if (aCount > bCount) System.out.println('A');
        else if (aCount < bCount) System.out.println('B');
        else System.out.println("Tie");
    }
}
