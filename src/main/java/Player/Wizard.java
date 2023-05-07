package Player;

import Character.Character;
import Game.Game;
import Pet.Pet;
import Wand.Wand;
import House.House;
import Spell.Spell;
import Spell.ForbiddenSpell;
import Spell.ApplySpell;
import Potion.Potion;
import java.util.List;
import java.util.Random;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Wizard extends Character {
    public Pet pet;
    public Wand wand;
    public House house;
    private List<Spell> knownSpells;
    private List<ForbiddenSpell> knownForbiddenSpells;
    private List<ApplySpell> knownApplySpell;
    private List<Potion> potions;

    public Wizard(int HP, String name, int pharmacy, int attack, int defense, int precise, int level, Pet pet, Wand wand, House house, List<Spell> knownSpells, List<ForbiddenSpell> knownForbiddenSpells, List<ApplySpell> knownApplySpells, List<Potion> potions,int gold) {
        super(HP, name, pharmacy, attack, defense, precise, level,gold);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.knownForbiddenSpells = knownForbiddenSpells;
        this.knownApplySpell = knownApplySpells;
        this.potions = potions;
    }


    public void attack(Wizard wizard, Character enemy, Spell spell) {
        Random random = new Random();
        double number = random.nextDouble();
        if (number < wizard.getPrecise()+wizard.getPrecise()*0.05) {
            int injury = (int)((spell.getDamage() + wizard.getAttack())*((100-(enemy.getDefense()))*0.01));
            int enemyHP = enemy.getHP() - injury;
            System.out.println("You have dealt "+injury+" points of damage to "+enemy.getName()+"!");
            enemy.setHP(enemyHP);
            System.out.println("The "+enemy.getName()+" has "+enemyHP+" HP points left.");
        }else {
            System.out.println("The magic spell did not hit.");
        }
    }
    public void usePotion(Wizard wizard, Potion potion){
        int HP = Game.property[1]+(potion.getAddHP()+(int)(potion.getAddHP()*wizard.getPharmacy()*0.1));
        Game.property[1] = HP;
        System.out.println("You have used "+potion.getName()+" and your HP has increased by "+(potion.getAddHP()+(int)(potion.getAddHP()*wizard.getPharmacy()*0.1))+" points!");
        System.out.println("Your current HP is "+Game.property[1]+" points.");
    }
    public void forbiddenAttack(Wizard wizard, Character enemy, ForbiddenSpell forbiddenSpell) {
        Random random = new Random();
        double number = random.nextDouble();
        if (number < wizard.getPrecise()+wizard.getPrecise()*0.05) {
            int injury = (int)((forbiddenSpell.getDamage() + wizard.getAttack())*((100-(enemy.getDefense()))*0.01));
            int enemyHP = enemy.getHP() - injury;
            System.out.println("You have dealt "+injury+" points of damage to "+enemy.getName()+"!");
            enemy.setHP(enemyHP);
            System.out.println("The "+enemy.getName()+" has "+enemyHP+" HP points left.");
        }else {
            System.out.println("The magic spell did not hit.");
        }
    }
    public static void defend(Character enemy) {
        System.out.println("You have chosen to defend.");
        Random random = new Random();
        double number = random.nextDouble();
        if (number <= 0.6f){
            System.out.println("The defense was successful and you received no damage.");
        }else {
            System.out.println("Defensive failure.");
            enemy.attack(Game.wizard, enemy, Game.spells.get(0));
        }
    }
}
