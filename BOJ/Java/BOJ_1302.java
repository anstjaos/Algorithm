import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BOJ_1302 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> bookSellCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();

            if (bookSellCount.containsKey(book)) {
                bookSellCount.put(book, bookSellCount.get(book) + 1);
            } else {
                bookSellCount.put(book, 1);
            }
        }
        br.close();

        List<Map.Entry<String, Integer>> bookList = bookSellCount.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
                    return o2.getValue().compareTo(o1.getValue());
                })
                .collect(Collectors.toList());

        System.out.println(bookList.get(0).getKey());
    }
}
