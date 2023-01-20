# Assignment_1 - RPG Heroes



## Introduction

The following program is a Maven application written in Java for a library of RPG heroes - Warrior, Ranger, Rogue and Mage.
This application has the necessary library to let the user create an Hero and equip it with a weapon and armor. It's attributes (strenght, dexterity and intelligence) can and will be influenced by the equipped items. Leveling up is also contemplated.

***

## Overview

- Each Hero has a particular combination of attributes at level 1 and each Hero increments it's attributes in different magnitudes when leveling up. It depends on the Hero class - Warrior, Ranger, Rogue and Mage.

- The attributes for each Hero class is Strength, Dexterity and Intelligence.

- A hero can equip one weapon and three sets of armor. Each set of armor can be equipped by the Head, Legs and Body.

- A weapon can only influence the Hero's damage.

- Armor, regardless of where's it's located - Head, Legs and body -, influences all the Hero's attributes

- Each Hero class has a damaging attribute, which has an influence on damage. For example, a Warrior has it's damage influenced by the strenght attribute.

- Each Hero class has it's own valid weapons and armor. For example, the user is not allowed to equip a Warrior with a weapon supposed to be used by a Mage.

- The Hero can only equip an item if it's level is equal or greater than the required level to equip the said item.

***

## Dependency

- The project has one dependency: JUnit. Tests were created in order to validate the correct implementation of all the methods.


