import java.io.*;

public class BOJ_2596 {
    private static String[] letter = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        br.close();

        StringBuilder result = new StringBuilder();
        boolean isFind = true;
        int count = 0;
        for (int i = 0; i < N; i++) {
            String temp = input.substring(i * 6, (i + 1) * 6);
            int minDiff = Integer.MAX_VALUE, minIdx = -1;
            for (int j = 0; j < 8; j++) {
                int diff = 0;
                for (int k = 0; k < 6; k++) {
                    if (temp.charAt(k) != letter[j].charAt(k)) diff++;
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    minIdx = j;
                }
                if (diff == 0) {
                    minIdx = j;
                    break;
                }
            }

            if (minDiff >= 2) {
                isFind = false;
                count = i + 1;
                break;
            } else {
                result.append((char) ('A' + minIdx));
            }
        }

        if (!isFind) System.out.println(count);
        else System.out.println(result);
    }
}
