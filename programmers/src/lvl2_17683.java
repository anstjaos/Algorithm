import java.util.*;

public class lvl2_17683 {
    private class Music {
        String melody;
        String name;
        int index;

        public Music(String melody, String name, int index) {
            this.melody = melody;
            this.name = name;
            this.index = index;
        }
    }

    public String solution(String m, String[] musicinfos) {
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String musicInfo = musicinfos[i];
            String[] parsedMusic = musicInfo.split(",");
            int minutes = getDiffTime(parsedMusic[0], parsedMusic[1]);

            StringBuilder sb = new StringBuilder();
            String melody = changeMusic(parsedMusic[3]);
            for (int j = 0; j < minutes; j++) {
                sb.append(melody.charAt(j % melody.length()));
            }

            musicList.add(new Music(sb.toString(), parsedMusic[2], i));
        }
        m = changeMusic(m);
        musicList.sort((m1, m2) -> {
            if (m1.melody.length() == m2.melody.length()) {
                return m1.index - m2.index;
            }

            return m2.melody.length() - m1.melody.length();
        });

        String answer = "(None)";
        for (Music music : musicList) {
            if (music.melody.contains(m)) {
                answer = music.name;
                break;
            }
        }
        return answer;
    }

    private int getDiffTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int minutes = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);

        boolean isMinusHour = false;
        if (minutes < 0) {
            isMinusHour = true;
            minutes += 60;
        }

        int hour = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
        hour = (isMinusHour ? hour - 1 : hour);

        return hour * 60 + minutes;
    }

    private String changeMusic(String music) {
        music = music.replaceAll("C#", "H");
        music = music.replaceAll("D#", "I");
        music = music.replaceAll("F#", "J");
        music = music.replaceAll("G#", "K");
        return music.replaceAll("A#", "L");
    }
}
