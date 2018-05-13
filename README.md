# DND5E Playtest Simulator
Once finished, this tool will allow you to get a rough estimate of how difficult an encounter will be, by simulating battles a high number of times, using quantifiable abilites (attack rolls, abilities that grant advantage, etc.)

## Goal
Goal of this tool is to help Dungeon Masters (or DMs) estimate the difficulty of battle scenarios by
estimating how many players survive (and maybe by how much). The DM then uses these estimates and knowledge
about the players' and creatures' behaviours and abilities to estimate how difficult the battle scenario is for the
players.

## Methods
To reach that goal, battles are simulated several times (order of magnitude 10^4), and the basic types of actions are considered:
 *  doing damage
 *  healing someone
 *  granting advantage
 *  modifying attack damage

Battle aspects like movement, terrain, etc. are not considered. Nor are more complex abilities like a bard's "Crown
of Madness". Therefore this is no real simulator, but more of an estimator (maybe we should change the name \*cough\*).


## Motivation
It's our own experience that it's hard to estimate the difficulty level
of a DND5E battle, even with Wizards of the Coast's challenge rating system, which turns out to greatly overestimate
the difficulty. "Deadly" battles frequently turned out to be way too easy for our players.