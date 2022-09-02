import java.util.*;

public class lvl2_42583 {
    class Truck {
        int weight;
        int startTime;

        public Truck(int weight, int startTime) {
            this.weight = weight;
            this.startTime = startTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();
        int truckIdx = 0;

        int curWeight = 0;
        int curTime = 0;
        while (truckIdx < truck_weights.length) {
            curTime++;
            if (!queue.isEmpty()) {
                Truck truck = queue.peek();
                if (curTime - truck.startTime >= bridge_length) {
                    queue.poll();
                    curWeight -= truck.weight;
                }
            }

            if (queue.size() == bridge_length) continue;

            if (truck_weights[truckIdx] + curWeight <= weight) {
                queue.add(new Truck(truck_weights[truckIdx], curTime));
                curWeight += truck_weights[truckIdx];
                truckIdx++;
            }
        }


        return curTime + bridge_length;
    }
}
