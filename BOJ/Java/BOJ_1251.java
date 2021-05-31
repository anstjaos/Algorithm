import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        List<String> stringList = new ArrayList<>();
        for (int i = 1; i < size - 1; i++) {
            for (int j = i+1; j < size; j++) {
                StringBuilder temp = new StringBuilder(input.substring(0, i)).reverse();
                temp.append(new StringBuilder(input.substring(i, j)).reverse());
                temp.append(new StringBuilder(input.substring(j, size)).reverse());

                stringList.add(temp.toString());
            }
        }
        br.close();
        Collections.sort(stringList);
        System.out.println(stringList.get(0));
    }
}
