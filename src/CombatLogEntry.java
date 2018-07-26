import java.util.List;

public class CombatLogEntry {

    private String name;
    private List<Creature> targets; // Implement small Tuple class!
    private List<Integer> targetHealthChanges;
    private DamageType type;
    private String description;

}
