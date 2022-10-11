import java.io.*;

public class BOJ_14038 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int winCount = 0;
        for (int i = 0; i < 6; i++) {
            String input = br.readLine();
            if (input.equals("W")) {
                winCount++;
            }
        }

        int result = -1;
        if (winCount >= 5) result = 1;
        else if (winCount >= 3) result = 2;
        else if (winCount >= 1) result = 3;
        br.close();
        System.out.println(result);
    }
}
