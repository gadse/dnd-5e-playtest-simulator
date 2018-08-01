import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void testJSONParsing() {
        Input input = new Input("test/players.json");
        for (Creature c: input.getPlayers()) {
            check_values(c);
        }
        for (Creature c: input.getEnemies()) {
            check_values(c);
        }

    }

    private void check_values(Creature c) {
        assert c != null;
        assert c.getStrength() > 0;
        assert c.getDexterity() > 0;
        assert c.getConstitution() > 0;
        assert c.getIntelligence() > 0;
        assert c.getWisdom() > 0;
        assert c.getCharisma() > 0;
        assert c.getClassOrCreature() != null;
        for (DamageType r: c.getResistances()) {
            assert r != null;
        }
        for (DamageType w: c.getWeaknesses()) {
            assert w != null;
        }
    }

}
