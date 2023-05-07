package Enemy;

import Character.Character;
import Game.Game;
import Player.Wizard;
import Spell.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Boss extends AbstractEnemy {

    public Boss(int HP, int initialHP, String name, int pharmacy, int attack, int defense, int precise, int level, List<Spell> knownSpells,int gold) {
        super(HP, initialHP, name, pharmacy, attack, defense, precise, level, knownSpells,gold);
    }
    public static final Boss troll = new Boss(250,250, "Troll", 5, 40, 20, 20, 1,new ArrayList<Spell>(Arrays.asList(Spell.reducto)),50);
    public static final Boss basilic = new Boss( 300,300, "Basilic", 5, 50, 50, 25, 1,new ArrayList<Spell>(Arrays.asList(Spell.reducto)),60);
    public static final Boss dementor = new Boss(400, 400,"Dementor", 5, 65, 30, 30, 1,new ArrayList<Spell>(Arrays.asList(Spell.incendio)),75);
    public static final Boss peterPettigrew = new Boss(500,500, "Peter Pettigrew", 5, 80, 40, 35, 1,new ArrayList<Spell>(Arrays.asList(Spell.incendio)),100);
    public static final Boss doloresOmbrage = new Boss(600, 600,"Dolores Ombrage", 5, 100, 50, 40, 1,new ArrayList<Spell>(Arrays.asList(Spell.deprimo)),125);
    public static final Boss doloresOmbrageLeader = new Boss(750, 750,"Dolores Ombrage Leader", 5, 120, 60, 60, 1,new ArrayList<Spell>(Arrays.asList(Spell.deprimo)),150);
    public static final Boss bellatrixLestrange = new Boss(900,900, "Bellatrix Lestrange", 5, 150, 60, 60, 1,new ArrayList<Spell>(Arrays.asList(Spell.expulso)),200);
    public static final Boss voldemort = new Boss(1000, 1000,"Voldemort", 5, 180, 60, 70, 1,new ArrayList<Spell>(Arrays.asList(Spell.expulso)),250);
    public void attack(Wizard wizard, Character boss, Spell spell) {
        Random random = new Random();
        double number = random.nextDouble();
        if (number < spell.getPrecise()+boss.getPrecise()*0.05) {
            int injury = (int)((spell.getDamage() + boss.getAttack())*((100-(wizard.getDefense()))*0.01));
            int wizardHP = Game.property[1] - injury;
            System.out.println("Enemy has dealt "+ injury +" points of damage to you!");
            Game.property[1] = wizardHP;
            if (Game.property[1]<=0){
                System.out.println("You have been defeated!");
                System.exit(0); // 结束程序
            }
        }else {
            System.out.println("The enemy's attack missed!");
        }
    }
    public void resetHP() {
        setHP(initialHP);
    }

}