import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    private static Combat combat = null;

    private List<Creature> simpleCreatureLists(int health) {
        List<Creature> creatures = new LinkedList<>();
        creatures.add(new Creature(health));
        return creatures;
    }

    @BeforeEach
    void setUp() {
        List<Creature> players = new LinkedList<>();
        players.add(new Creature());
        List<Creature> enemies = new LinkedList<>();
        enemies.add(new Creature());
        combat = new Combat(players, enemies);
    }

    @Test
    void simulate() {
        List<List<Creature>> result = combat.simulate();
        assertNotNull(result);
        for (List<Creature> list: result) {
            assert list.size() > 0;
        }
    }

    @Test
    void creaturesShouldBeAlive() {
        assert combat.playersAlive();
        assert combat.enemiesAlive();
    }

    @Test
    void enemiesShouldNotBeAlive() {
        List<Creature> players = simpleCreatureLists(1);
        List<Creature> enemies = simpleCreatureLists(0);
        combat = new Combat(players, enemies);

        assert combat.playersAlive();
        assertFalse(combat.enemiesAlive());
    }

    @Test
    void playersShouldNotBeAlive() {
        List<Creature> players = simpleCreatureLists(0);
        List<Creature> enemies = simpleCreatureLists(1);
        combat = new Combat(players, enemies);

        assertFalse(combat.playersAlive());
        assert combat.enemiesAlive();
    }

    @Test
    void nobodyShouldBeAlive() {
        List<Creature> players = simpleCreatureLists(0);
        List<Creature> enemies = simpleCreatureLists(0);
        combat = new Combat(players, enemies);

        assertFalse(combat.playersAlive());
        assertFalse(combat.enemiesAlive());
    }

}