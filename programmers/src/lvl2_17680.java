import java.util.*;

public class lvl2_17680 {
    class City implements Comparable<City> {
        String name;
        int index;

        public City (String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(City c) {
            return this.index - c.index;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof City)) {
                return false;
            }

            City c = (City) o;

            return this.name.equalsIgnoreCase(c.name);
        }
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();

        for (int i = 0; i < cities.length; i++) {
            String cur = cities[i];
            City curCity = new City(cur, i);
            if (pq.contains(curCity)) {
                pq.remove(curCity);
                pq.add(curCity);
                answer += 1;
            } else {
                if (pq.size() >= cacheSize) {
                    pq.poll();
                }

                if (pq.size() < cacheSize) {
                    pq.add(curCity);
                }

                answer += 5;
            }
        }
        return answer;
    }
}
