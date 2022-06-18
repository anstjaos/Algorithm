public class lvl1_42840 {
    public int[] solution(int[] answers) {
        int[] mathOne = {1, 2, 3, 4, 5}; // 5
        int mathOneCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == mathOne[i % 5]) {
                mathOneCount++;
            }
        }

        int[] mathTwo = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int mathTwoCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == mathTwo[i % 8]) {
                mathTwoCount++;
            }
        }

        int[] mathThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        int mathThreeCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == mathThree[i % 10]) {
                mathThreeCount++;
            }
        }

        int[] answer = new int[1];

        if (mathOneCount == mathTwoCount && mathTwoCount == mathThreeCount) {
            answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        } else if (mathOneCount == mathTwoCount && mathOneCount != mathThreeCount && mathOneCount > mathThreeCount) {
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 2;
        } else if (mathOneCount == mathThreeCount && mathOneCount != mathTwoCount && mathOneCount > mathTwoCount) {
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 3;
        } else if (mathTwoCount == mathThreeCount && mathTwoCount > mathOneCount) {
            answer = new int[2];
            answer[0] = 2;
            answer[1] = 3;
        } else if (mathOneCount > mathTwoCount && mathOneCount > mathThreeCount) {
            answer[0] = 1;
        } else if (mathTwoCount > mathOneCount && mathTwoCount > mathThreeCount) {
            answer[0] = 2;
        } else if (mathThreeCount > mathOneCount && mathThreeCount > mathTwoCount) {
            answer[0] = 3;
        }
        return answer;
    }
}
