import java.io.*;

public class BOJ_3029 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String start = br.readLine();
        String end = br.readLine();
        br.close();

        String[] startArr = start.split(":");
        String[] endArr = end.split(":");

        int[] resultArr = new int[3];

        StringBuilder sb = new StringBuilder();

        boolean isMinus = false;
        for (int i = 2; i >= 0; i--) {
            int endTime = Integer.parseInt(endArr[i]), startTime = Integer.parseInt(startArr[i]);
            if (isMinus) {
                endTime--;
                isMinus = false;
            }

            if (endTime < 0) {
                if (i == 0) endTime += 24;
                else endTime += 60;
                isMinus = true;
            }

            if (endTime < startTime) {
                if (i == 0) endTime += 24;
                else endTime += 60;
                isMinus = true;
            }

            resultArr[i] = endTime - startTime;
        }

        if (start.equals(end)) {
            System.out.println("24:00:00");
        }
        else {
            for (int i = 0; i < 3; i++) {
                sb.append(String.format("%02d", resultArr[i]));
                if (i != 2) sb.append(":");
            }
            System.out.println(sb);
        }

    }
}
