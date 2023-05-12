import java.util.*;

public class lvl3_42884 {
    class Car {
        int start, end;

        Car() {}
        Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(int[][] routes) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            carList.add(new Car(routes[i][0], routes[i][1]));
        }

        carList.sort(Comparator.comparingInt(a -> a.end));

        int answer = 0;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < routes.length; i++) {
            if (end < carList.get(i).start) {
                end = carList.get(i).end;
                answer++;
            }
        }

        return answer;
    }
}
