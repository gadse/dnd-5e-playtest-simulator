import java.util.List;

/**
 * This class implements what attack modifiers are to be applied. This includes things like "you deal 1d4 additional
 * damage once during your next four turns" or "you gain advantage for your next attack".
 */
public class AttackModifier implements CombatAction {
    public String name;
    public ModifierType type;
    public List<Integer> dice;
    /**A value of -1 indicates infinite duration*/
    public int duration;
    /**A value of -1 indicates infinite usages for the given duration*/
    public int usages;

    @Override
    public String describe() {
        return null;
    }
}
