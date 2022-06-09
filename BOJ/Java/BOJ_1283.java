import java.io.*;
import java.util.*;

public class BOJ_1283 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        boolean[] isUsed = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> wordList = new ArrayList<>();
            while (st.hasMoreTokens()) {
                wordList.add(st.nextToken());
            }

            boolean isFind = false;
            for (int j = 0; j < wordList.size(); j++) {
                String word = wordList.get(j);
                if (isFind) {
                    sb.append(word).append(" ");
                    continue;
                }

                String wordLowerCase = word.toLowerCase();
                if (!isUsed[wordLowerCase.charAt(0) - 'a']) {
                    for (int k = 0; k < j; k++) {
                        sb.append(wordList.get(k)).append(" ");
                    }
                    isUsed[wordLowerCase.charAt(0) - 'a'] = true;
                    isFind = true;
                    sb.append("[").append(word.charAt(0)).append("]");

                    for (int k = 1; k < word.length(); k++) {
                        sb.append(word.charAt(k));
                    }
                    sb.append(" ");
                }
            }

            if (isFind) {
                sb.append("\n");
                continue;
            }

            for (int j = 0; j < wordList.size(); j++) {
                String word = wordList.get(j);
                if (isFind) {
                    sb.append(word).append(" ");
                    continue;
                }
                String wordToLowerCase = word.toLowerCase();

                int length = wordToLowerCase.length();
                int index = -1;
                for (int k = 0; k < length; k++) {
                    char cur = wordToLowerCase.charAt(k);

                    if (!isUsed[(cur - 'a')]) {
                        index = k;
                        isUsed[(cur - 'a')] = true;
                        break;
                    }
                }

                if (index != -1) {
                    for (int k = 0; k < length; k++) {
                        if (index != k) sb.append(word.charAt(k));
                        else {
                            sb.append("[").append(word.charAt(k)).append("]");
                        }
                    }
                    sb.append(" ");
                    isFind = true;
                } else {
                    sb.append(word).append(" ");
                }
            }
            sb.append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
