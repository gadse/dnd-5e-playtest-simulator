import java.util.List;

public class CombatLogEntry {

    private String name;
    private List<Creature> targets;
    private List<Integer> targetHealthChanges;
    private DamageType type;
    private String description;

}
