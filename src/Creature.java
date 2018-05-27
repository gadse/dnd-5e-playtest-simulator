import java.util.List;
import lombok.Data;

/**
 * Used to model both players and creatures, since players ARE creatures.
 * For creatures that don't have a playable class, use class CreatureClass.CREATURE.
 */
@Data
public class Creature {

    private String name;
    private CreatureClass playerClass;

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

    private List<DamageTypes> resistances;
    private List<DamageTypes> weaknesses;

    private boolean advantage;

}
