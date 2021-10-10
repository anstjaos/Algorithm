import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10825 {
    private static class Student implements Comparable<Student> {
        private String name;
        private int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor != o.kor) return o.kor - this.kor;
            else if (this.eng != o.eng) return this.eng - o.eng;
            else if (this.math != o.math) return o.math - this.math;

            return this.name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append("\n");
        }

        System.out.print(sb);
    }
}
