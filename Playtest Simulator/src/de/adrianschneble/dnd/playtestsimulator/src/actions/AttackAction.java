package de.adrianschneble.dnd.playtestsimulator.src.actions;

import de.adrianschneble.dnd.playtestsimulator.src.Damage;
import de.adrianschneble.dnd.playtestsimulator.src.Roll;
import de.adrianschneble.dnd.playtestsimulator.src.actions.actionattributes.HarmfulAction;
import de.adrianschneble.dnd.playtestsimulator.src.actions.actionattributes.targets.MultiTargetAction;
import de.adrianschneble.dnd.playtestsimulator.src.actions.actionattributes.type.RegularAction;
import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;

public class AttackAction extends MultiTargetAction implements RegularAction, HarmfulAction {

	private int attackRollBonus;
	private Damage damage;

	public AttackAction(int attackRollBonus, Damage damage, int attackCount) {
		super(attackCount);
		this.attackRollBonus = attackRollBonus;
		this.damage = damage;
	}

	public AttackAction(int attackRollBonus, Damage damage) {
		this(attackRollBonus, damage, 1);
	}

	@Override
	public void apply(Creature... targets) throws IllegalTargetCountException {
		if (targets.length == this.targetCount) {
			for (Creature target : targets) {
				attack(target);
			}
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
