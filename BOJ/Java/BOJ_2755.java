import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2755 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int totalCount = 0;
        double totalSum = 0.0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            String score = st.nextToken();

            totalCount += num;

            double grade = 0.0;
            switch (score) {
                case "A+":
                    grade = 4.3;
                    break;
                case "A0":
                    grade = 4.0;
                    break;
                case "A-":
                    grade = 3.7;
                    break;
                case "B+":
                    grade = 3.3;
                    break;
                case "B0":
                    grade = 3.0;
                    break;
                case "B-":
                    grade = 2.7;
                    break;
                case "C+":
                    grade = 2.3;
                    break;
                case "C0":
                    grade = 2.0;
                    break;
                case "C-":
                    grade = 1.7;
                    break;
                case "D+":
                    grade = 1.3;
                    break;
                case "D0":
                    grade = 1.0;
                    break;
                case "D-":
                    grade = 0.7;
                    break;
                default:
                    grade = 0.0;
                    break;
            }

            totalSum += (grade * num);
        }
        br.close();

        System.out.printf("%.2f%n", (totalSum / totalCount));
    }
}
