import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2621 {

    private static class Card implements Comparable<Card> {
        char color;
        int num;

        public Card(char color, int num) {
            this.color = color;
            this.num = num;
        }

        @Override
        public int compareTo(Card o) {
            return this.num - o.num;
        }
    }

    private static Card[] cards;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        cards = new Card[5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cards[i] = new Card(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cards);
        br.close();

        int result = cards[4].num + 100;

        if (isSameColor()) {
            boolean isAsc = isAsc();

            if (isAsc) result = Math.max(result, cards[4].num + 900);
            else result = Math.max(result, cards[4].num + 600);
        }

        if (cards[0].num == cards[3].num ) result = Math.max(result, cards[0].num + 800);
        if (cards[1].num == cards[4].num) result = Math.max(result, cards[1].num + 800);

        if (cards[0].num == cards[2].num && cards[3].num == cards[4].num) result = Math.max(result, cards[0].num * 10 + cards[3].num + 700);
        if (cards[0].num == cards[1].num && cards[2].num == cards[4].num) result = Math.max(result, cards[2].num * 10 + cards[0].num + 700);

        if (isAsc()) result = Math.max(result, cards[4].num + 500);

        if (cards[0].num == cards[2].num && cards[3].num != cards[4].num) result = Math.max(result, cards[0].num + 400);
        if (cards[1].num == cards[3].num && cards[3].num != cards[4].num) result = Math.max(result, cards[1].num + 400);
        if (cards[0].num != cards[1].num && cards[2].num == cards[4].num) result = Math.max(result, cards[2].num + 400);

        if (cards[0].num == cards[1].num && cards[1].num != cards[2].num && cards[2].num == cards[3].num && cards[3].num != cards[4].num)
            result = Math.max(result, cards[2].num * 10 + cards[0].num + 300);
        if (cards[0].num == cards[1].num && cards[1].num != cards[2].num && cards[2].num != cards[3].num && cards[3].num == cards[4].num)
            result = Math.max(result, cards[3].num * 10 + cards[0].num + 300);
        if (cards[0].num != cards[1].num && cards[1].num == cards[2].num && cards[2].num != cards[3].num && cards[3].num == cards[4].num)
            result = Math.max(result, cards[3].num * 10 + cards[1].num + 300);

        if (cards[0].num == cards[1].num) result = Math.max(result, cards[0].num + 200);
        if (cards[1].num == cards[2].num) result = Math.max(result, cards[1].num + 200);
        if (cards[2].num == cards[3].num) result = Math.max(result, cards[2].num + 200);
        if (cards[3].num == cards[4].num) result = Math.max(result, cards[3].num + 200);

        System.out.println(result);
    }

    private static boolean isSameColor() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].color != cards[i-1].color) return false;
        }

        return true;
    }

    private static boolean isAsc() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].num - cards[i - 1].num != 1) {
                return false;
            }
        }

        return true;
    }
}
