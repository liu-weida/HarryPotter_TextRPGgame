package Enemy;
import Character.Character;
import Player.Wizard;
import Spell.Spell;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class AbstractEnemy extends Character {
    private List<Spell> knownSpells;
    public final int initialHP;
    public AbstractEnemy(int HP, int initialHP, String name, int pharmacy, int attack, int defense, int precise, int level, List<Spell> knownSpells,int gold) {
        super(HP, name, pharmacy, attack, defense, precise, level,gold);
        this.knownSpells = knownSpells;
        this.initialHP = initialHP;
    }

    public abstract void attack(Wizard wizard, Character enemy, Spell spell);


}
