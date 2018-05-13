# Input
For each **player**:
 *  Name (optional, could help with interpreting results)
 *  Class
 *  Level
 *  STR, DEX, CON, CHA, WIS, INT
 *  Max and start HP
 *  Spell slots
 *  Spell modifier (STR, DEX, etc)
 *  Attack count
 *  List of attacks
 *  List of heal actions
 *  List of attack modifiers
 *  List of resistances
 *  List of weaknesses
 *  Starting advantage status

For each **attack**:
 *  Name
 *  Target count
 *  Damage (like XdY+Z)
 *  Damage Type (Like "piercing" or "fire")
 *  Delay (how many turns later this turn can be used)
 *  Ammunition (Ammunition for bows or charges for staves)
 *  Cooldown

For each **heal action**:
 *  Name
 *  Target count
 *  Target (self or other or both)
 *  HP recovery (like XdY+Z)
 *  Charges
 *  Cooldown

For each **attack modifier**:
 *  Name
 *  Target count
 *  Bonus damage (like XdY+Z)
 *  Bonus damage type (like "piercing" or "fire")
 *  Target (self or other or both)

# Output
A battle ends when all players or all creatures are reduced to 0 HP.

We return an overview of how likely certain outcomes are.
An outcome lists the HP of every player and enemy at the end of the battle.

Example output:
```
PLAYERS             GRAPH   ROBABILITY  
6 dead, 0 alive     #       5%          
5 dead, 1 alive     ##      10%         
4 dead, 2 alive     ######  30%         
3 dead, 3 alive     ####    20%         
2 dead, 4 alive     ###     15%         
1 dead, 5 alive     ####    20%         
0 dead, 6 alive             0%          
```

# Transformation
We can use Markov chains to simulate the battle round by round until the end. We can do this several times (paramerer!)
to obtain empirical data.

Furthermore we could implement different target acquisition strategies like "most/least HP first",
"more like most/least HP", or "totally random". We could also assume that a creature targets enemy X when it's likely
that a blow would kill X.

Maybe (!) we can use basic probability theory and use (discrete) distributions for calculations. In the end we would
obtain survival chances for each of the characters, and use them to calculate survival rates for M players for M in
{0,.. N} with total player count N. But we'll do the basic empirical stuff first, since it's easier.