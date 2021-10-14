import java.io.*;

public class BOJ_10101 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine());
        br.close();

        if (a == 60 && b == 60 && c == 60) System.out.println("Equilateral");
        else if (a + b + c == 180) {
            if (a == b || a == c || b == c) System.out.println("Isosceles");
            if (a != b && a != c && b != c) System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
    }
}
