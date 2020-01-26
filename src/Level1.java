import java.util.*;

public class Level1 {
    public static boolean LineAnalysis(String line) {
        int lineLength = line.length();
        int countDots = 0;
        int tempCount = 0;
        int countStars = 0;

        if (line.charAt(0) != '*' || line.charAt(lineLength - 1) != '*') return false;
        for (int i = 1; i < lineLength; i++) {
            if (line.charAt(i) != '*' && line.charAt(i) != '.') return false;
            if (line.charAt(i) == '*') {
                if (countDots > 0) {
                    if (tempCount > 0 && tempCount != countDots) return false;
                    if (i == lineLength - 1 && tempCount != countDots) return false;
                    if (countStars > 0 && tempCount != countDots) return false;
                    tempCount = countDots;
                    countDots = 0;
                    countStars ++;
                    continue;
                }
                if (tempCount != countDots) return false;
                countStars++;
            } else {
                countDots++;
            }
        }
        return true;
    }
}