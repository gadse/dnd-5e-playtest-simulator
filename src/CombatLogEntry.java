import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CombatLogEntry {

    private String name;
    private List<Pair<Creature, Integer>> effects;
    private DamageType type;
    private String description;

}
