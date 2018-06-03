import java.util.List;
import lombok.Data;

/**
 * Used to model both players and creatures, since players ARE creatures.
 * For creatures that don't have a playable class, use class CreatureType.CREATURE.
 */
@Data
public class Creature {

    private String name;
    private CreatureType playerClass;

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

    //ToDo: Attack Count
    //ToDo: Attack List
    //ToDo: Heal Action List
    //ToDo: Attack Modifier List

    private List<DamageType> resistances;
    private List<DamageType> weaknesses;

    private boolean advantage;

    public Creature() {
        this.health = 1;
    }

    public Creature(int health) {
        this.health = health;
    }

}
