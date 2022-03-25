import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ_5568 {
    private static int[] cards;
    private static Set<Long> cardNumSet = new HashSet<>();
    private static int n, k;
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new int[n];
        isSelected = new boolean[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        solve("", 0);
        System.out.println(cardNumSet.size());
    }

    private static void solve(String num, int count) {
        if (count == k) {
            cardNumSet.add(Long.parseLong(num));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            solve(num + cards[i], count + 1);
            isSelected[i] = false;
        }
    }
}
