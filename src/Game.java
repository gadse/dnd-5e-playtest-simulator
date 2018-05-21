import java.util.List;

public class Game {

    private List<Creature> players;
    private List<Creature> enemies;
    private int round = 1;

    //ToDo Combat Log

    /**
     * Creates a new game with the given players and enemies. No sanity checks
     * are performed here, since that is done in the Creature constructor.
     */
    public Game(List<Creature> players, List<Creature> enemies) {
        this.players = players;
        this.enemies = enemies;
    }


    public List<List<Creature>> simulate() {
        //ToDo
        return null;
    }

    private void playRound() {
        //TODO
    }

}
