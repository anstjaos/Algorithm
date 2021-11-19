import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2456 {
    private static class Student implements Comparable<Student> {
        int threeCount, twoCount, oneCount, total, num;

        public Student(int num) {
            this.num = num;
        }

        public void plusThreeCount() {
            threeCount++;
            total += 3;
        }

        public void plusTwoCount() {
            twoCount++;
            total += 2;
        }

        public void plusOneCount() {
            oneCount++;
            total += 1;
        }

        @Override
        public int compareTo(Student o) {
            if (this.total != o.total) return o.total - this.total;
            else if (this.threeCount != o.threeCount) return o.threeCount - this.threeCount;
            else if (this.twoCount != o.twoCount) return o.twoCount - this.twoCount;

            return o.oneCount - this.oneCount;
        }

        @Override
        public boolean equals(Object o) {
            Student compare = (Student) o;

            if (this.total != compare.total) return false;
            else if (this.threeCount != compare.threeCount) return false;
            else if (this.twoCount != compare.twoCount) return false;
            else if (this.oneCount != compare.oneCount) return false;

            return true;
        }
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[3];
        for (int i = 1; i <= 3; i++) students[i - 1] = new Student(i);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 3) {
                    students[j].plusThreeCount();
                } else if (num == 2) {
                    students[j].plusTwoCount();
                } else if (num == 1) {
                    students[j].plusOneCount();
                }
            }
        }
        br.close();

        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();
        if (students[0].equals(students[1])) sb.append("0 ");
        else sb.append(students[0].num).append(" ");

        sb.append(students[0].total);
        System.out.println(sb);
    }
}
