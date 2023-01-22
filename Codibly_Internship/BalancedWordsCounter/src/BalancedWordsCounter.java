import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class BalancedWordsCounter {
    public static int count(String input) {
        if (input == null) {
            throw new RuntimeException("RuntimeException");
        }
        if (input.equals("")) {
            return 0;
        }
        if (!input.matches("^[a-zA-Z]+$")) {
            throw new RuntimeException("RuntimeException");
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String sub = input.substring(i, j + 1);
                if (isBalanced(sub)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isBalanced(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int first = charCount.get(input.charAt(0));
        for (int count : charCount.values()) {
            if (count != first) {
                return false;
            }
        }
        return true;
    }
}

class BalancedWordsCounterTest {
    @Test
    public void testCase1() {
        String input = "aabbabcccba";
        int expected = 28;
        assertEquals(expected, BalancedWordsCounter.count(input));
    }

    @Test
    public void testCase2() {
        String input = "";
        int expected = 0;
        assertEquals(expected, BalancedWordsCounter.count(input));
    }

    @Test
    public void testCase3() {
        String input = "abababa1";
        Assertions.assertThrows(RuntimeException.class, () -> BalancedWordsCounter.count(input));
    }

    @Test
    public void testCase4() {
        String input = null;
        Assertions.assertThrows(RuntimeException.class, () -> BalancedWordsCounter.count(input));
    }
}