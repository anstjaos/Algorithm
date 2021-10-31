import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8979 {
    private static class Country implements Comparable<Country> {
        int num, gold, silver, bronze, rank;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) return o.gold - this.gold;
            else if (this.silver != o.silver) return o.silver - this.silver;
            else if (this.bronze != o.bronze) return o.bronze - this.bronze;
            else return this.num - o.num;
        }

        @Override
        public boolean equals(Object o) {
            Country compare = (Country) o;

            if (this.gold == compare.gold && this.silver == compare.silver && this.bronze == compare.bronze) return true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Country[] countries = new Country[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            countries[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        Arrays.sort(countries);
        countries[0].rank = 1;
        if (countries[0].num == K) {
            System.out.println(1);
            return;
        }


        for (int i = 1; i < N; i++) {
            if (countries[i].equals(countries[i - 1])) countries[i].rank = countries[i - 1].rank;
            else countries[i].rank = i + 1;

            if (countries[i].num == K) {
                System.out.println(countries[i].rank);
                return;
            }
        }
    }
}
