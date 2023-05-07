package Character;


import Player.Wizard;
import Spell.Spell;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class Character{
    private String name;
    private int level;
    public static int HP;
    private int gold;
    private int pharmacy;  //药水
    private int attack;  //攻击
    private int defense;  //防御
    private int precise;  //精准

    public Character(int HP, String name, int pharmacy, int attack, int defense, int precise, int level, int gold ){
        this.name = name;
        this.level = level;
        Character.HP = HP;
        this.pharmacy = pharmacy;
        this.attack = attack;
        this.defense = defense;
        this.precise = precise;
        this.gold = gold;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        Character.HP = HP;
    }

    public abstract void attack(Wizard wizard, Character enemy, Spell spell);

}
