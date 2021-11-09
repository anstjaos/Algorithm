import java.io.*;

public class BOJ_17009 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int banana = 0, apple = 0;

        for (int i = 3; i >= 1; i--) {
            apple += Integer.parseInt(br.readLine()) * i;
        }

        for (int i = 3; i >= 1; i--) {
            banana += Integer.parseInt(br.readLine()) * i;
        }
        br.close();

        if (banana > apple) System.out.println("B");
        else if (banana < apple) System.out.println("A");
        else System.out.println("T");
    }
}
