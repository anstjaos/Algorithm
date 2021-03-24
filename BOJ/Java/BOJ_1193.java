import java.io.*;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());

        if (X == 1) {
            System.out.println("1/1");
            br.close();
            return;
        }

        StringBuilder sb = new StringBuilder();

        int addCount = 1, prevSum = 0;

        while(true) {
            if (X <= prevSum + addCount) {
                if (addCount % 2 == 0) {
                    sb.append(X - prevSum)
                            .append("/")
                            .append(addCount - (X - prevSum - 1));
                } else {
                    sb.append(addCount - (X - prevSum - 1))
                            .append("/")
                            .append(X - prevSum);
                }
                break;
            }
            prevSum += addCount;
            addCount++;
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
