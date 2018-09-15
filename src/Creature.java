import lombok.Data;
import lombok.NonNull;
import java.util.List;

/**
 * Used to model both players and creatures, since players ARE creatures.
 * For creatures that don't have a playable class, use class CreatureType.CREATURE.
 */
@Data
public class Creature {

    @NonNull private String name;
    @NonNull private CreatureType classOrCreature;

    private int xp;
    private int strength;
    private int dexterity;
    private int constitution;
    private int charisma;
    private int wisdom;
    private int intelligence;

    private int health;
    private int maxHealth;
    private int armorClass;

    //ToDo: Spell Slots
    //ToDo: Spell Modifier

    private int attackCount;
    private List<Attack> attacks;
    /***/
    private List<HealAction> healActions;
    private List<AttackModifier> modifiers;

    @NonNull private List<DamageType> resistances;
    @NonNull private List<DamageType> weaknesses;

    private boolean advantage;

    public Creature() {
        this.health = 1;
    }

    public Creature(int health) {
        this.health = health;
    }

}
