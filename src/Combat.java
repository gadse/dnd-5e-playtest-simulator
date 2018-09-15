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

    private void simulateRound() {
        // TODO
        // generate initiative-sorted list of all creatures
        // for each creature in the list:
        //     Choose one action by a simple heuristic and execute. Choose targets with simple heuristic.
        //     Don't forget to apply status changes like checking off inspiration dice.
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

    public String toString() {
        return "Round "+round+" | PLA: "+players+" | ENE: "+enemies+" | LOG: " + log;
    }

    public String toPrettyString() {
        return "== Round "+round+" =="+
                "\n> PLA: "+getPrettyCreatureList(players)+
                "\n> ENE: "+getPrettyCreatureList(enemies)+"" +
                "\n> LOG: "+log;
    }

    public String getPrettyCreatureList(List<Creature> creatures) {
        String prettyList="[\n";
        if (creatures.isEmpty()) {
            prettyList += "\t--empty--";
        }
        for (Creature c: creatures) {
            prettyList += "\t" + c.toString();
        }
        prettyList += "\n]";
        return prettyList;
    }

}
