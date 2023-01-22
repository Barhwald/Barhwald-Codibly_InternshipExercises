import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class BubbleSort {
    public static List<Comparable> sort(List<Comparable> input) throws RuntimeException {
        if (input == null) {
            throw new RuntimeException("RuntimeException");
        }
        input = new ArrayList<>(input);
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size() - 1; j++) {
                if (input.get(j) != null && input.get(j + 1) != null) {
                    if (input.get(j) instanceof Integer && input.get(j+1) instanceof Double) {
                        input.set(j, (double)(Integer)input.get(j));
                    } else if (input.get(j) instanceof Double && input.get(j+1) instanceof Integer) {
                        input.set(j+1, (double)(Integer)input.get(j+1));
                    }
                    if (input.get(j).compareTo(input.get(j + 1)) > 0) {
                        Comparable temp = input.get(j);
                        input.set(j, input.get(j + 1));
                        input.set(j + 1, temp);
                    }
                } else if (input.get(j) == null && input.get(j + 1) != null) {
                    input.remove(j);
                    i--;
                } else if (input.get(j) != null && input.get(j + 1) == null) {
                    input.remove(j + 1);
                    i--;
                }
            }
        }
        return input;
    }
}


class BubbleSortTest {

    @Test
    public void testCase1() {
        List<Comparable> input = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        List<Comparable> expected = Arrays.asList(1, 3, 4, 5, 6, 8, 8);
        assertEquals(expected, BubbleSort.sort(input));

    }

    @Test
    public void testCase2() {
        List<Comparable> input = Arrays.asList(-9.3, 0.2, 4, 0.1, 5, 9);
        List<Comparable> expected = Arrays.asList(-9.3, 0.1, 0.2, 4, 5, 9);
        assertEquals(expected, BubbleSort.sort(input));
    }

    @Test
    public void testCase3() {
        List<Comparable> input = Arrays.asList();
        List<Comparable> expected = Arrays.asList();
        assertEquals(expected, BubbleSort.sort(input));
    }

    @Test
    public void testCase4() {
        List<Comparable> input = Arrays.asList(null, 5.0001);
        List<Comparable> expected = Arrays.asList(5.0001);
        assertEquals(expected, BubbleSort.sort(input));
    }

    @Test
    public void testCase5() {
        List<Comparable> input = null;
        Assertions.assertThrows(RuntimeException.class, () -> BubbleSort.sort(input));
    }
}