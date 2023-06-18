import java.util.*;

public class lvl2_17686 {
    class FileName {
        Integer index;
        String head;
        String defaultNumber;
        Integer number;
        String tail;

        FileName() {}
        FileName(Integer index, String file) {
            this.index = index;

            int i = 0;
            for (; i < file.length(); i++) {
                if ('0' <= file.charAt(i) && file.charAt(i) <= '9') break;
            }
            this.head = file.substring(0, i);

            int numStart = i;
            for (; i < file.length(); i++) {
                if (!('0' <= file.charAt(i) && file.charAt(i) <= '9')) break;
            }
            this.defaultNumber = file.substring(numStart, i);
            this.number = Integer.valueOf(this.defaultNumber);
            this.tail = file.substring(i);
        }

        public String getFileName() {
            return this.head + this.defaultNumber + this.tail;
        }
    }

    public String[] solution(String[] files) {
        List<FileName> fileNames = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            fileNames.add(new FileName(i, files[i]));
        }

        fileNames.sort((a, b) -> {
            if (!a.head.equalsIgnoreCase(b.head)) {
                return a.head.compareToIgnoreCase(b.head);
            }
            if (!Objects.equals(a.number, b.number)) {
                return a.number - b.number;
            }
            return a.index - b.index;
        });
        return fileNames.stream().map(FileName::getFileName).toList().toArray(String[]::new);
    }
}
