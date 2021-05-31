import java.io.*;

public class BOJ_3054 {
    private static String[] firstLine = {"..#.", "..*."};
    private static String[] firstLineEnd = {"..#..", "..*.."};

    private static String[] secondLine = {".#.#", ".*.*"};
    private static String[] secondLineEnd = {".#.#.", ".*.*."};

    private static String[] thirdLine = {"#.", "*.", "."};
    private static String[] thirdLineEnd = {"#.", ".#", "*.", ".*"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] result = new String[5];
        br.close();

        for (int i = 0; i < 5; i++) {
            String cur = "";
            for (int j = 0; j < input.length(); j++) {
                int index = j + 1;
                if (i == 0 || i == 4) {
                    if (index % 3 == 0) {
                        if (j == input.length() - 1) cur = cur.concat(firstLineEnd[1]);
                        else cur = cur.concat(firstLine[1]);
                    } else {
                        if (j == input.length() - 1) cur = cur.concat(firstLineEnd[0]);
                        else cur = cur.concat(firstLine[0]);
                    }
                } else if (i == 1 || i == 3) {
                    if (index % 3 == 0) {
                        if (j == input.length() - 1) cur = cur.concat(secondLineEnd[1]);
                        else cur = cur.concat(secondLine[1]);
                    } else {
                        if (j == input.length() - 1) cur = cur.concat(secondLineEnd[0]);
                        else cur = cur.concat(secondLine[0]);
                    }
                } else {
                    if (index % 3 == 0) {
                        if (j == input.length() - 1)
                            cur = cur.concat(thirdLineEnd[2]).concat(String.valueOf(input.charAt(j))).concat(thirdLineEnd[3]);
                        else
                            cur = cur.concat(thirdLine[1]).concat(String.valueOf(input.charAt(j))).concat(thirdLine[2]);
                    } else if ((index -1 ) % 3 == 0 & index - 1 != 0) {
                        if (j == input.length() - 1)
                            cur = cur.concat(thirdLineEnd[2]).concat(String.valueOf(input.charAt(j))).concat(thirdLineEnd[1]);
                        else
                            cur = cur.concat(thirdLine[1]).concat(String.valueOf(input.charAt(j))).concat(thirdLine[2]);
                    } else {
                        if (j == input.length() - 1)
                            cur = cur.concat(thirdLineEnd[0]).concat(String.valueOf(input.charAt(j))).concat(thirdLineEnd[1]);
                        else
                            cur = cur.concat(thirdLine[0]).concat(String.valueOf(input.charAt(j))).concat(thirdLine[2]);
                    }
                }
            }
            result[i] = cur;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(result[i]).append("\n");

        System.out.print(sb);
    }
}
