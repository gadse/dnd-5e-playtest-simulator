import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    private static List<Integer> eyeCounts = Arrays.asList(4, 6, 8, 10, 12, 20);
    private static int dieBound = 10;

    @Test
    void roll() {
        for(int eyeCount: eyeCounts) {
            for (int i = 0; i < 1000; i++) {
                int rolled = Die.roll(eyeCount);
                assert 0 < rolled && rolled <= eyeCount;
            }
        }
    }

    @Test
    void roll_several() {
        for(int eyeCount: eyeCounts) {
            for(int runs = 0; runs < 1000; runs++) {
                int dieCount = new Random().nextInt(dieBound);
                List<Integer> params = Collections.nCopies(dieCount, eyeCount);
                List<Integer> dies = Die.roll(params.toArray(new Integer[params.size()]));
                for (int die: dies) {
                    assert 0 < die && die <= eyeCount;
                }
            }
        }
    }
}