import java.util.List;

public class Game {

    private List<Creature> players;
    private List<Creature> enemies;
    private int round = 1;

    //TODO: Combat Log

    /**
     * Creates a new game with the given players and enemies. No sanity checks
     * are performed here, since that is done in the Creature constructor.
     */
    public Game(List<Creature> players, List<Creature> enemies) {
        this.players = players;
        this.enemies = enemies;
    }


    public List<List<Creature>> simulate() {

        return null;
    }

    private boolean enemies_alive() {
        return creatures_alive(enemies);
    }

    private boolean players_alive() {
        return creatures_alive(players);
    }


    private boolean creatures_alive(List<Creature> creatures) {
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
        //TODO
    }

}
