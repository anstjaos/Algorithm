import java.io.*;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int[] numCount = new int[10];

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            numCount[num]++;
            sum += num;
        }

        if (numCount[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 9 ; i >= 0; i--) {
            while (numCount[i] > 0) {
                result.append(i);
                numCount[i]--;
            }
        }
        System.out.println(result);
    }
}
