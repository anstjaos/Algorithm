import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24465 {
    private static class ApproveMember implements Comparable<ApproveMember> {
        int month, day;

        public ApproveMember(int month, int day) {
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(ApproveMember o) {
            if (this.month == o.month) {
                return this.day - o.day;
            }

            return this.month - o.month;
        }
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] stars = new boolean[12];

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[getStarIndex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))] = true;
        }

        int num = Integer.parseInt(br.readLine());
        List<ApproveMember> approveMembers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken()), day = Integer.parseInt(st.nextToken());
            int index = getStarIndex(month, day);
            if (!stars[index]) {
                approveMembers.add(new ApproveMember(month, day));
            }
        }

        Collections.sort(approveMembers);
        StringBuilder sb = new StringBuilder();
        for (ApproveMember member : approveMembers) {
            sb.append(member.month).append(" ").append(member.day).append("\n");
        }

        if (approveMembers.size() == 0) {
            sb.append("ALL FAILED\n");
        }

        br.close();
        System.out.print(sb);
    }

    private static int getStarIndex(int month, int day) {
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return 0;
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return 1;
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return 2;
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return 3;
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) return 4;
        else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) return 5;
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return 6;
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return 7;
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return 8;
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 22)) return 9;
        else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) return 10;

        return 11;
    }
}
