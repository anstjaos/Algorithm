import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_5217 {
    private static class Pair {
        int num1, num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return num1 + " " + num2;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        Map<Integer, List<Pair>> numPairMap = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            List<Pair> pairList = new ArrayList<>();

            for (int j = 1; j < i - j; j++) {
                pairList.add(new Pair(j, i - j));
            }
            numPairMap.put(i, pairList);
        }

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append("Pairs for ").append(num).append(": ");
            List<Pair> pairList = numPairMap.get(num);
            for (int i = 0; i < pairList.size(); i++) {
                sb.append(pairList.get(i).toString());
                if (i != pairList.size() - 1) sb.append(", ");
            }

            sb.append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
