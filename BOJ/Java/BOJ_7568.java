import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7568 {

    public static class Person {
        public int height;
        public int weight;

        public Person() {}
        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] personArr = new Person[55];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            personArr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        boolean[][] isBigger = new boolean[55][55];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (personArr[i].height > personArr[j].height && personArr[i].weight > personArr[j].weight) {
                    isBigger[i][j] = true;
                } else if (personArr[i].height < personArr[j].height && personArr[i].weight < personArr[j].weight) {
                    isBigger[j][i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (isBigger[j][i]) count++;
            }
            sb.append(count + " ");
        }

        System.out.println(sb.toString());
    }
}
