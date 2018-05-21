import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Die {

    private static Random generator = new Random();

    public static int roll(int sides) {
        return 1 + generator.nextInt(sides);
    }

    /**
     * Returns a list of die rolls that corresponds to the list of die sides given as argument.
     * @param sides A list of die sides.
     * @return A list of roll results.
     */
    public static List<Integer> roll(Integer... sides) {
        if (sides == null) {
            throw new IllegalArgumentException("sides may not be null.");
        }
        List<Integer> result = new LinkedList<>();
        for(int eyeCount: sides) {
            result.add(roll(eyeCount));
        }
        return result;
    }

}
