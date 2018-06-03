import java.util.LinkedList;
import java.util.List;

/**
 * Represents a full combat from the first round to the last.
 */
public class Combat {

    private List<Creature> players;
    private List<Creature> enemies;

    private int round;
    private List<CombatLogEntry> log;

    /**
     * Creates a new combat with the given players and enemies. No sanity checks
     * are performed here, since that is done in the Creature constructor.
     *
     * @param players: A list of players.
     * @param enemies: A list of enemies the players need to fight. These can be humanoids that fall into the DND player
     *               class schema, or creatures like owlbears, bugbears, and so on.
     */
    public Combat(List<Creature> players, List<Creature> enemies) {
        this.players = players;
        this.enemies = enemies;
        this.round = 1;
        this.log = new LinkedList<>();
    }


    public List<List<Creature>> simulate() {
        // TODO
        return null;
    }

    public boolean enemiesAlive() {
        return creaturesAlive(enemies);
    }

    public boolean playersAlive() {
        return creaturesAlive(players);
    }


    private boolean creaturesAlive(List<Creature> creatures) {
        boolean result = false;
        for (Creature creature: creatures) {
            if (creature.getHealth() > 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    private void playRound() {
        // TODO
    }

}
