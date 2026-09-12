package string.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    public static void main(String[] args) {
        runCheck("swiss");
        runCheck("aabbcc");
    }

    public static void runCheck(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : text.toCharArray()) {
            if (counts.get(c) == 1) return c;
        }
        return '\0';
    }
}
