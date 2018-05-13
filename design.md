*Just some random thoughts to get to our object model more easily...*

The **game** holds a list of **players** and a list of **creatures**. The game also holds a **combat log**,
which is a chronologically ordered list of **battle actions**. Every **attack**, **heal action**, or **attack modifier**
is a combat action.

Each of the creatures _attacks_ one or several times per round.
For an attack, the players _roll_ one or several **dies** to determine the **attack damage**. Each attack
has one or several **targets**. The attack's targets reduce their HP based on the damage, **resistances**, and
**weaknesses**.
If the **damage type** is one of a target's resistances/weaknesses, the damage is _halved-and-floored_, or _doubled_.
The targets then reduce their HP by the _resulting damage_.

**Heal actions** and **attack modifiers** are conducted similarly to attacks, but neither resistances nor weaknesses
apply, obviously.

