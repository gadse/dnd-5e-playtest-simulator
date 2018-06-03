import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private static Game game = null;

    @BeforeAll
    static void setUp() {
        List<Creature> players = new LinkedList<Creature>();
        players.add(new Creature());
        List<Creature> enemies = new LinkedList<Creature>();
        enemies.add(new Creature());
        game = new Game(players, enemies);

        List<List<Creature>> result = game.simulate();
        assertNotNull(result);
        for (List<Creature> list: result) {
            assert list.size() > 0;
        }
    }

    @Test
    void simulate() {

    }

}