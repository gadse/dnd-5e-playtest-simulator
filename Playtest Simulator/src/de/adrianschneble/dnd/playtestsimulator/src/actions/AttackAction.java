package de.adrianschneble.dnd.playtestsimulator.src.actions;

import de.adrianschneble.dnd.playtestsimulator.src.Damage;
import de.adrianschneble.dnd.playtestsimulator.src.Roll;
import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;

public class AttackAction implements Action {

	private int attackRollBonus;
	private Damage damage;

	public AttackAction(int attackRollBonus, Damage damage) {
		this.attackRollBonus = attackRollBonus;
		this.damage = damage;
	}

	@Override
	public void apply(Creature... targets) throws IllegalTargetCountException {
		if (targets.length == 1) {
			Creature target = targets[0];
			attack(target);
		} else {
			throw new IllegalTargetCountException();
		}
	}

	private void attack(Creature target) {
		int attackRoll = Roll.d20() + attackRollBonus;
		if (attackRoll >= target.getArmorClass()) {
			dealDamageTo(target);
		}
	}

	private void dealDamageTo(Creature target) {
		int damageRoll = damage.roll();
		target.takeDamage(damageRoll);
	}

}
