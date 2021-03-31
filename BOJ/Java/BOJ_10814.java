import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10814 {

    public static class Member implements Comparable<Member> {
        public int age;
        public String name;
        public int index;

        public Member() {}
        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.index - o.index;
            }

            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[100005];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(members, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i].age + " " + members[i].name + "\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
