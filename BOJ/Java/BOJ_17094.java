import java.io.*;

public class BOJ_17094 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int twoCount = 0, eCount = 0;
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);
            if (cur == '2') twoCount++;
            else if (cur == 'e') eCount++;
        }

        if (twoCount > eCount) System.out.println(2);
        else if (twoCount < eCount) System.out.println("e");
        else System.out.println("yee");
        br.close();
    }
}
