import java.io.*;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();
        int[] arr = new int[30];
        for (int i = 0; i < length; i++) {
            arr[input.charAt(i) - 'A']++;
        }

        StringBuilder temp = new StringBuilder();
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;

            while (arr[i] > 1) {
                temp.append((char) ('A' + i));
                arr[i] -= 2;
            }
            if (arr[i] == 1) oddCount++;

            if (oddCount >= 2) break;
        }

        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder result = new StringBuilder();
        result.append(temp);

        if (oddCount == 1) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 1) {
                    result.append((char) ('A' + i));
                    break;

                }
            }
        }

        result.append(temp.reverse());
        System.out.println(result);
    }
}
