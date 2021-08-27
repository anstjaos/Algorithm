import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1269 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken()), bSize = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> aSet2 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            int num = Integer.parseInt(st.nextToken());
            aSet.add(num);
            aSet2.add(num);
        }
        Set<Integer> bSet = new HashSet<>();
        Set<Integer> bSet2 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int num = Integer.parseInt(st.nextToken());
            bSet.add(num);
            bSet2.add(num);
        }
        br.close();

        for (Integer num : bSet) {
            aSet.remove(num);
        }

        for (Integer num : aSet2) {
            bSet2.remove(num);
        }

        System.out.println(aSet.size() + bSet2.size());
    }
}
