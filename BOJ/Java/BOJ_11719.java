import java.io.*;
import java.util.Scanner;

public class BOJ_11719 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = "";
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input).append("\n");
        }
        sc.close();
        System.out.println(sb);
    }
}
