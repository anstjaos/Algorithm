import java.io.*;

public class BOJ_17293 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = N; i >= 0; i--) {
            if (i == 1) {
                sb.append("1 bottle of beer on the wall, 1 bottle of beer.\n")
                        .append("Take one down and pass it around, no more bottles of beer on the wall.\n\n");
            } else if (i == 2) {
                sb.append("2 bottles of beer on the wall, 2 bottles of beer.\n")
                        .append("Take one down and pass it around, 1 bottle of beer on the wall.\n\n");
            } else if (i == 0) {
                if (N == 1) {
                    sb.append("No more bottles of beer on the wall, no more bottles of beer.\n")
                            .append("Go to the store and buy some more, ").append(N).append(" bottle of beer on the wall.");
                } else {
                    sb.append("No more bottles of beer on the wall, no more bottles of beer.\n")
                            .append("Go to the store and buy some more, ").append(N).append(" bottles of beer on the wall.");
                }
            } else {
                sb.append(i).append(" bottles of beer on the wall, ").append(i).append(" bottles of beer.\n")
                        .append("Take one down and pass it around, ").append(i - 1).append(" bottles of beer on the wall.\n\n");
            }
        }

        System.out.println(sb);
    }
}
