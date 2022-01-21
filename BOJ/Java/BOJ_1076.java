import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1076 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Map<String, Integer> resistMap = new HashMap<>();
        resistMap.put("black", 0);
        resistMap.put("brown", 1);
        resistMap.put("red", 2);
        resistMap.put("orange", 3);
        resistMap.put("yellow", 4);
        resistMap.put("green", 5);
        resistMap.put("blue", 6);
        resistMap.put("violet", 7);
        resistMap.put("grey", 8);
        resistMap.put("white", 9);

        String color = br.readLine();
        long result = resistMap.get(color);
        color = br.readLine();
        result *= 10;
        result += resistMap.get(color);

        color = br.readLine();
        int num = resistMap.get(color);
        for (int i = 0; i < num; i++) result *= 10;

        br.close();

        System.out.println(result);
    }
}
