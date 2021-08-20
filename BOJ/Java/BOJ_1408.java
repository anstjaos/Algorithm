import java.io.*;

public class BOJ_1408 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String curTime = br.readLine();
        String startTime = br.readLine();
        br.close();

        int curH = Integer.parseInt(curTime.substring(0, 2)), curM = Integer.parseInt(curTime.substring(3, 5)), curS = Integer.parseInt(curTime.substring(6, 8));
        int startH =  Integer.parseInt(startTime.substring(0, 2)), startM = Integer.parseInt(startTime.substring(3, 5)), startS = Integer.parseInt(startTime.substring(6, 8));

        int diffS = getDiff(startS, curS);
        if (diffS < 0) {
            diffS += 60;
            startM -= 1;
        }
        int diffM = getDiff(startM, curM);
        if (diffM < 0) {
            diffM += 60;
            startH -= 1;
        }
        int diffH = getDiff(startH, curH);
        if (diffH < 0) diffH += 24;

        System.out.println(String.format("%02d", diffH) + ":" + String.format("%02d", diffM) + ":" + String.format("%02d", diffS));
    }

    private static int getDiff(int start, int cur) {
        return start - cur;
    }
}
