import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class BOJ_5635 {
    private static class Student implements Comparable<Student> {
        String name;
        Date birthday;

        public Student(String name, Date birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public int compareTo(Student o) {
            return this.birthday.compareTo(o.birthday);
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken()), month = Integer.parseInt(st.nextToken()), year = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, new Date(year - 1900, month - 1, day));
        }

        Arrays.sort(students);
        br.close();

        System.out.println(students[n-1].name);
        System.out.println(students[0].name);
    }
}
