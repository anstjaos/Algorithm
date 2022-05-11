import java.io.*;
import java.util.*;

public class BOJ_2910 {
    private static class Number implements Comparable<Number> {
        int num, count, firstIndex;

        public Number(int num, int count, int firstIndex) {
            this.num = num;
            this.count = count;
            this.firstIndex = firstIndex;
        }

        @Override
        public int compareTo(Number o) {
            if (count == o.count) {
                return this.firstIndex - o.firstIndex;
            }
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, 1);
                numbers.add(new Number(num, 1, 0));
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        br.close();

        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            number.count = map.get(number.num);
            number.firstIndex = i;

            numbers.set(i, number);
        }

        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (Number number : numbers) {
            for (int i = 0; i < number.count; i++) sb.append(number.num).append(" ");
        }
        System.out.println(sb);
    }
}
