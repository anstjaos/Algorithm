public class BOJ_9654 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n")
                .append("N2 Bomber      Heavy Fighter  Limited    21        \n")
                .append("J-Type 327     Light Combat   Unlimited  1         \n")
                .append("NX Cruiser     Medium Fighter Limited    18        \n" +
                        "N1 Starfighter Medium Fighter Unlimited  25        \n" +
                        "Royal Cruiser  Light Combat   Limited    4         \n");

        System.out.print(sb);
    }
}
