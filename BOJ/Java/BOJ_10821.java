import java.io.*;

public class BOJ_10821 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();

        String[] parsedInput = input.split(",");
        int length = parsedInput.length;


        br.close();
        System.out.println(length);
    }
}
