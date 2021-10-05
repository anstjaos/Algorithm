import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2605 {
    private static class Student {
        int num;
        Student left, right;

        public Student(int num, Student left, Student right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        Student start = new Student(0, null, null);
        Student tail = start;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            Student newStudent = new Student(i, tail, null);
            int skip = Integer.parseInt(st.nextToken());

            Student temp = tail;
            while (skip-- > 0) {
                temp = temp.left;
            }

            if (temp.right != null) temp.right.left = newStudent;
            newStudent.right = temp.right;
            temp.right = newStudent;
            newStudent.left = temp;

            while (tail.right != null) {
                tail = tail.right;
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        start = start.right;
        while (start != null) {
            sb.append(start.num).append(" ");
            start = start.right;
        }
        System.out.println(sb);
    }
}
