import java.io.*;

public class BOJ_2754 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        if (input.equals("A+")) System.out.println(4.3);
        else if (input.equals("A0")) System.out.println(4.0);
        else if (input.equals("A-")) System.out.println(3.7);
        else if (input.equals("B+")) System.out.println(3.3);
        else if (input.equals("B0")) System.out.println(3.0);
        else if (input.equals("B-")) System.out.println(2.7);
        else if (input.equals("C+")) System.out.println(2.3);
        else if (input.equals("C0")) System.out.println(2.0);
        else if (input.equals("C-")) System.out.println(1.7);
        else if (input.equals("D+")) System.out.println(1.3);
        else if (input.equals("D0")) System.out.println(1.0);
        else if (input.equals("D-")) System.out.println(0.7);
        else System.out.println(0.0);
    }
}
