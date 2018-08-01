import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Attack implements CombatAction {
    @NonNull private String name;
    @NonNull private AttackType attackType;
    @NonNull private DamageType damageType;
    @NonNull private int dieCount;
    @NonNull private int dieType;
    @NonNull private int offset;
    private int damage = 0;

    public void roll() {
        Integer[] dies = new Integer[dieCount];
        dies = Collections.nCopies(dieCount, dieType).toArray(dies);
        this.damage = Die.roll(dies).stream().reduce(0, (a, b) -> a + b) + offset;
    }

    @Override
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" | ").append(attackType).append(" | ")
                .append(dieCount).append("d").append(dieType).append("+").append(offset).append(" ").append(damageType);
        if (damage > 0) {
            sb.append("\nDamage Roll: ").append(damage);
        }
        return sb.toString();
    }

}
