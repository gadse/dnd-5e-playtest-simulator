import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.LinkedList;
import java.util.List;

/**
 * Used to model both players and creatures, since players ARE creatures.
 * For creatures that don't have a playable class, use class CreatureType.CREATURE.
 */
@Data
public class Creature {

    private String name;
    private CreatureType classOrCreature;

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

    public Creature(JSONObject o) {
        this.name = (String) o.get("Name");
        this.classOrCreature = CreatureType.valueOf((String) o.get("class"));
        this.xp = (int) o.get("xp");

        this.strength = (int) o.get("strength");
        this.dexterity = (int) o.get("dexterity");
        this.constitution = (int) o.get("constitution");
        this.charisma = (int) o.get("charisma");
        this.wisdom = (int) o.get("wisdom");
        this.intelligence = (int) o.get("intelligence");
        this.health = (int) o.get("health");
        this.maxHealth = (int) o.get("maxHealth");
        this.armorClass = (int) o.get("armorClass");

        JSONArray res = o.getJSONArray("resistances");
        this.resistances = new LinkedList<>();
        for (Object r: res) {
            this.resistances.add(DamageType.valueOf((String) r));
        }

        JSONArray wea = o.getJSONArray("weaknesses");
        this.weaknesses = new LinkedList<>();
        for (Object w: wea) {
            this.weaknesses.add(DamageType.valueOf((String) w));
        }

        this.advantage = (boolean) o.get("advantage");
    }

}
