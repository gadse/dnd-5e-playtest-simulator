import lombok.NonNull;

public class HealAction implements CombatAction {
    @NonNull private String name;
    @NonNull private int dieCount;
    @NonNull private int dieType;
    @NonNull private int offset;
    private int amount = -1;

    @Override
    public String describe() {
        return name + "| HEAL | "+dieCount+"d"+dieType+"+"+offset+" HP.";
    }
}
