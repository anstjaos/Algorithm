public class lvl1_67256 {
    public String solution(int[] numbers, String hand) {
        int[][] distance = new int[11][11];
        distance[1][2] = distance[3][2] = 1;
        distance[1][5] = distance[3][5] = 2;
        distance[1][8] = distance[3][8] = 3;
        distance[1][0] = distance[3][0] = 4;

        distance[4][2] = distance[6][2] = 2;
        distance[4][5] = distance[6][5] = 1;
        distance[4][8] = distance[6][8] = 2;
        distance[4][0] = distance[6][0] = 3;

        distance[7][2] = distance[9][2] = 3;
        distance[7][5] = distance[9][5] = 2;
        distance[7][8] = distance[9][8] = 1;
        distance[7][0] = distance[9][0] = 2;

        distance[2][2] = 0;
        distance[2][5] = 1;
        distance[2][8] = 2;
        distance[2][0] = 3;

        distance[5][2] = 1;
        distance[5][5] = 0;
        distance[5][8] = 1;
        distance[5][0] = 2;

        distance[8][2] = 2;
        distance[8][5] = 1;
        distance[8][8] = 0;
        distance[8][0] = 1;

        distance[0][2] = 3;
        distance[0][5] = 2;
        distance[0][8] = 1;
        distance[0][0] = 0;

        distance[10][2] = 4;
        distance[10][5] = 3;
        distance[10][8] = 2;
        distance[10][0] = 1;

        String answer = "";

        int left = -1, right = -1;
        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    left = numbers[i];
                    break;
                case 3:
                case 6:
                case 9:
                    answer += "R";
                    right = numbers[i];
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    if (left == -1 && right == -1) {
                        if (hand.charAt(0) == 'l') {
                            left = numbers[i];
                            answer += "L";
                        } else {
                            right = numbers[i];
                            answer += "R";
                        }
                    } else if (left == -1) {
                        if (distance[10][numbers[i]] < distance[right][numbers[i]]) {
                            left = numbers[i];
                            answer += "L";
                        } else if (distance[10][numbers[i]] > distance[right][numbers[i]]) {
                            right = numbers[i];
                            answer += "R";
                        } else {
                            if (hand.charAt(0) == 'l') {
                                left = numbers[i];
                                answer += "L";
                            } else {
                                right = numbers[i];
                                answer += "R";
                            }
                        }
                    } else if (right == -1) {
                        if (distance[10][numbers[i]] < distance[left][numbers[i]]) {
                            right = numbers[i];
                            answer += "R";
                        } else if (distance[10][numbers[i]] > distance[left][numbers[i]]) {
                            left = numbers[i];
                            answer += "L";
                        } else {
                            if (hand.charAt(0) == 'l') {
                                left = numbers[i];
                                answer += "L";
                            } else {
                                right = numbers[i];
                                answer += "R";
                            }
                        }
                    } else {
                        if (distance[left][numbers[i]] < distance[right][numbers[i]]) {
                            left = numbers[i];
                            answer += "L";
                        } else if (distance[left][numbers[i]] > distance[right][numbers[i]]) {
                            right = numbers[i];
                            answer += "R";
                        } else {
                            if (hand.charAt(0) == 'l') {
                                left = numbers[i];
                                answer += "L";
                            } else {
                                right = numbers[i];
                                answer += "R";
                            }
                        }
                    }
                    break;
            }
        }

        return answer;
    }
}
